package com.cy.pj.test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.SysProjectDao;
import com.cy.pj.sys.service.SysProjectService;

@SpringBootTest
public class SysProjectTests {

	@Autowired
	SysProjectDao sysProjectDao;
	@Autowired
	SysProjectService sysProjectService;
	@Test
	public void sysProjectDaoTests() {
		System.out.println(sysProjectService.findPageObject(null, 1));
	}
}
