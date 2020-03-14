package com.cy.pj.sys.service;

import java.util.List;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;

public interface SysRoleService {

	public Integer getRowCount(String name);
	
	public PageObject<SysRole> findObjects(String name, Integer startIndex);
	
	public Integer deleteObjectByRoleId(Integer id);
	
	public Integer saveObject(SysRole sysRole, Integer[] menuIds);

	public SysRoleMenuVo findObjectById(Integer id);
	
	public Integer updateObject(SysRole sysRole, Integer[] menuIds);

	List<CheckBox> findObjects();
}
