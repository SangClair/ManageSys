package com.cy.pj.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.service.SysMenuService;

@SpringBootTest
public class SysMenusTests {

	@Autowired
	SysMenuDao sysMenuDao;
	
	@Autowired
	SysMenuService sysMenuService;
	
	@Test
	public void SysMenuDaoTests() {
		System.out.println(sysMenuDao.findAllObjects().size());
	}
	
	@Test
	public void SysMenuServiceTests() {
		System.out.println(sysMenuService.findAllObjects());
	}
	
	@Test
	public void SysMenuDaoTests2() {
		System.out.println(sysMenuDao.findZtreeMenuNodes());
	}
}
