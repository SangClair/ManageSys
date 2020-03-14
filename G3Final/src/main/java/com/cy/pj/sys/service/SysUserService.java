package com.cy.pj.sys.service;


import java.util.Map;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.entity.SysUser;

public interface SysUserService {

	public PageObject<SysUserDeptVo> findPageObjects(String name, Integer pageCurrent);
	
	public Integer validById(Integer id, Integer valid, String modifiedUser);
	
	public Integer insertObject(SysUser sysUser, Integer[] roleIds);
	
	public Map<String, Object> findObjectById(Integer id);
	
	public Integer updateObject(SysUser sysUser, Integer[] roleIds);
	
	
}
