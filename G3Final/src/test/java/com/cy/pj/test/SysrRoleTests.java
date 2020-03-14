package com.cy.pj.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.service.SysRoleService;

@SpringBootTest
public class SysrRoleTests {

	@Autowired
	SysRoleDao sysRoleDao;
	
	@Autowired
	SysRoleService sysRoleService;
	
	@Test
	void roleTests() {
		System.out.println(sysRoleDao.findPageObjects("", 0, 3));
	}
}
