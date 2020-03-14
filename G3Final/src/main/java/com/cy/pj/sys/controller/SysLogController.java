package com.cy.pj.sys.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/log/")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("doFindPageObjects")
	//@ResponseBody
	public JsonResult doFindPageObjects(String searchNameId, Integer pageCurrent) {
		JsonResult r = new JsonResult();
		PageObject<SysLog> data = sysLogService.findPageObject(searchNameId, pageCurrent);
		r.setData(data);
		return r;
	}
	
	@RequestMapping("doDeleteObjects")
	//@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		JsonResult r = new JsonResult();
		sysLogService.doDeleteObjects(ids);
		r.setMessage("delete ok");
		return r;
	}
	
	@RequestMapping("doExportLogs")
	public JsonResult doExportLogs(String fileName, Integer... ids) {
		System.out.println(fileName);
		System.out.println(Arrays.asList(ids));
		sysLogService.doExportLogs(fileName, ids);
		return new JsonResult("导出成功");
	}
	
	@RequestMapping("doImportLogs")
	public JsonResult doImportLogs(@RequestParam("upload") MultipartFile file) {
		sysLogService.importLogs(file);
		return new JsonResult("导入成功");
	}
}
