package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;

@Mapper
public interface SysRoleDao {

	
	public List<SysRole> findPageObjects(String name, Integer startIndex, Integer pageSize) ;
	
	public Integer getRowCount(String name);
	
	public Integer deleteObjectByRoleId(Integer id);
	
	public Integer insertObject(SysRole sysRole);
	
	public SysRoleMenuVo findObjectById(Integer id);
	
	public Integer updateObject(SysRole sysRole);
	
	public List<CheckBox> findObjects();

}
