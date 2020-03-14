package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {

	@Delete("delete from sys_role_menus where id = #{menuId}")
	public void deleteObjectsByMenuId(Integer menuId);
	
	public Integer deleteObjectByRoleId(Integer id);
	
	public Integer insertObjects(Integer roleId, Integer[] menuIds);
	
	public List<Integer> findObjectsByRoleId(Integer id);
	
	public List<Integer> findMenuIdsByRoleIds(@Param("roleIds") Integer[] roleIds);
}
