package com.cy.pj.sys.service;

import org.springframework.web.multipart.MultipartFile;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

public interface SysLogService {
	
	public PageObject<SysLog> findPageObject(String username, Integer pageCurrent);
	
	public Integer doDeleteObjects(Integer... ids);
	
	public Integer saveObject(SysLog sysLog);
	
	public void doExportLogs(String fileName, Integer... ids);

	public void importLogs(MultipartFile file);
}
