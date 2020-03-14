package com.cy.pj.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.common.config.PaginationProperties;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.service.SysLogService;

@SpringBootTest
public class SysLogTests {

	@Autowired
	SysLogService sysLogService;
	
	@Autowired
	SysLogDao sysLogDao;
	
	@Autowired
	PaginationProperties paginationProperties;
	
	@Test
	public void testGetRowCount() {
		System.out.println(sysLogDao.getRowCount("admin"));
	}
	
	@Test
	public void testsFindPageObject() {
		System.out.println(sysLogDao.findPageObject("admin", 3, 3));
	}
	
	@Test
	public void testsFindPageObjext2() {
		System.out.println(sysLogService.findPageObject(null, 2));
	}
	
}
