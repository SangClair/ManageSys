package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserRoleDao {
	
	public Integer deleteObjectByRoleId(Integer id);
	
	public Integer insertObject(@Param("userId") Integer userId, @Param("roleIds") Integer[] roleIds);
	
	public List<Integer> findRolesByUserId(Integer id);
	
	public Integer deleteObjectsByUserId(Integer userId);
	
	public List<Integer> findRoleIdsByUserId(Integer id);
}

