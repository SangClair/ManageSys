package com.cy.pj.sys.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cy.pj.common.config.PaginationProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.Assert;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;

@Service
public class SysLogServiceImpl implements SysLogService{
	@Autowired
	private SysLogDao sysLogDao;

	@Autowired
	private PaginationProperties paginationProperties;

	@Override
	public PageObject<SysLog> findPageObject(String username, Integer pageCurrent) {
		int pageSize = paginationProperties.getPageSize();
		Assert.isArgumentAvailable((pageCurrent == null || pageCurrent < 0), "页码值不正确");
		Integer rowCount = sysLogDao.getRowCount(username);
		Assert.isServiceVerified((rowCount == 0), "没有对应的记录");
		Integer startIndex = (pageCurrent - 1) * pageSize;
		List<SysLog> records = sysLogDao.findPageObject(username, startIndex, pageSize);
		PageObject<SysLog> pageObject = new PageObject<SysLog>(pageCurrent, pageSize, rowCount, records);
		return pageObject;
	}

	@Override
	public Integer doDeleteObjects(Integer... ids) {
		Assert.isArgumentAvailable((ids == null ||ids.length == 0), "请选中记录后删除");
		Integer rows = sysLogDao.deleteObjects(ids);
		Assert.isServiceVerified((rows ==0), "记录可能已经不存在");
		return rows;
	}

	@Override
	@Async
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Integer saveObject(SysLog sysLog) {
		Integer rows = sysLogDao.insertObject(sysLog);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.isServiceVerified(rows == null || rows == 0, "日志保存失败");
		return rows;
	}

	@Override
	public void doExportLogs(String fileName, Integer... ids){
		Assert.isArgumentAvailable(ids == null || ids.length == 0, "没有选择日志");
		List<SysLog> list = sysLogDao.findLogsByIds(ids);
		FileSystemView fsv = FileSystemView.getFileSystemView();
		String desktop = fsv.getHomeDirectory().getPath();
		String filePath = desktop + "/" + fileName + ".xls";

		File file = new File(filePath);
		Assert.isServiceVerified(file.exists(), "文件已存在");
		OutputStream outputStream = null;
		try {
			file.createNewFile();
			outputStream = new FileOutputStream(file);
		} catch (IOException e) {
			throw new ServiceException("存取失败");
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sheet1");
		sheet.setColumnWidth(3, 15000);
		sheet.setColumnWidth(6, 8000);
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("id");
		row.createCell(1).setCellValue("username");
		row.createCell(2).setCellValue("operation");
		row.createCell(3).setCellValue("method");
		row.createCell(4).setCellValue("time(ms)");
		row.createCell(5).setCellValue("ip");
		row.createCell(6).setCellValue("CreatedTime");
		row.setHeightInPoints(30);// 设置行的高度

		for (int i = 0; i < ids.length; i++) {
			HSSFRow row1 = sheet.createRow(i + 1);
			row1.createCell(0).setCellValue(list.get(i).getId());
			row1.createCell(1).setCellValue(list.get(i).getUsername());
			row1.createCell(2).setCellValue(list.get(i).getOperation());
			row1.createCell(3).setCellValue(list.get(i).getMethod());
			row1.createCell(4).setCellValue(list.get(i).getTime());
			row1.createCell(5).setCellValue(list.get(i).getIp());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			row1.createCell(6).setCellValue(simpleDateFormat.format(list.get(i).getCreatedTime()));
		}
		try {
			workbook.write(outputStream);
			outputStream.flush();    
			outputStream.close();
		} catch (IOException e) {
			throw new ServiceException("存取失败");
		}
	}

	@Override
	public void importLogs(MultipartFile file) {
		try {
			InputStream inputStream = file.getInputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
			HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
			HSSFSheet sheet = workbook.getSheet("Sheet1");

			int lastRowIndex = sheet.getLastRowNum();
			SysLog[] logs = new SysLog[lastRowIndex];
			for (int i = 1; i <= lastRowIndex; i++) {
				HSSFRow row = sheet.getRow(i);
				if (row == null) { break; }
				logs[i - 1] = new SysLog();
				
				HSSFCell cell = row.getCell(1);
				cell.setCellType(CellType.STRING);
				String username = cell.getStringCellValue();
				logs[i - 1].setUsername(username);
				
				HSSFCell cell2 = row.getCell(2);
				String operation = cell2.getStringCellValue();
				logs[i - 1].setOperation(operation);
				
				HSSFCell cell3 = row.getCell(3);
				String method = cell3.getStringCellValue();
				logs[i - 1].setMethod(method);
				
				HSSFCell cell4 = row.getCell(4);
				cell4.setCellType(CellType.STRING);
				String time = cell4.getStringCellValue();
				logs[i - 1].setTime(Long.parseLong(time));
				
				HSSFCell cell5 = row.getCell(5);
				cell.setCellType(CellType.STRING);
				String ip = cell5.getStringCellValue();
				logs[i - 1].setIp(time);
				
				HSSFCell cell6 = row.getCell(6);
				cell.setCellType(CellType.STRING);
				String createdTime = cell6.getStringCellValue();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date dateTime = simpleDateFormat.parse(createdTime);
				logs[i - 1].setCreatedTime(dateTime);
				
				sysLogDao.insertObject(logs[i - 1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("导入失败");
		}

	}
}
