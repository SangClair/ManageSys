package com.cy.pj.sys.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.config.PaginationProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysBrandDao;
import com.cy.pj.sys.entity.SysBrand;

@Service
public class SysBrandServiceImpl implements SysBrandService{
	@Autowired
	private SysBrandDao sysBrandDao;
	
	@Autowired
	private PaginationProperties pageProperties;
	
	@Override
	public SysBrand findObjectById(Integer id) {
		//if(id==null||id<1)
		//	throw new IllegalArgumentException("请选择正确信息");
		SysBrand sysBrand = sysBrandDao.findObjectById(id);
		return sysBrand;
	}
	
	@Override
	public int updateObject(SysBrand entity) {
		if(entity==null)
			throw new IllegalArgumentException("请输入要修改的信息");
		if(entity.getCorporatename()==null||"".equals(entity.getCorporatename()))
			throw new IllegalArgumentException("请输入公司名称");
		int rows = sysBrandDao.updateObject(entity);
		return rows;
	}
//==================================添加================================================
	@Override
	public int saveObjects(SysBrand entity) {
		if(entity.getCorporatename()==null||"".equals(entity.getCorporatename()))
			throw new IllegalArgumentException("请输入公司名称");
		if(entity.getTel()==null)
			throw new IllegalArgumentException("请输入公司联系方式");
		if(entity.getAddr()==null)
			throw new IllegalArgumentException("请输入公司地址");
		//if(entity.getCreatedTime()==null)
		//	throw new IllegalArgumentException("请输入合同开始时间");
		//if(entity.getEndTime()==null)
		//	throw new IllegalArgumentException("请输入合同到期时间");
		int rows = sysBrandDao.insertObjects(entity);
		return rows;
	}
		
	//===============================删除=========================================================
	@Override
	public int deleteObjects(Integer[] ids) {
		if(ids==null||ids.length==0)
			throw new IllegalArgumentException("请选择要删除的公司");
		int rows = sysBrandDao.deleteObjects(ids);
		if(rows==0) throw new ServiceException("您要删除的记录可能不存在");
		return rows;
	}
//================================分页查询==================================================
	@Override
	public PageObject<SysBrand> findPageObjects(String corporatename, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("请输入正确页码值");
		int rowCount = sysBrandDao.getRowCount(corporatename);
		if(rowCount==0)
			throw new ServiceException("没有你要查询的记录");
		int pageSize = pageProperties.getPageSize();
		int startIndex = pageProperties.startIndex(pageCurrent);
		List<SysBrand> records = sysBrandDao.findPageObjects(corporatename, startIndex, pageSize);
		PageObject pageObject = new PageObject<>(pageCurrent, pageSize, rowCount, records);
		return pageObject ;
	}

}
