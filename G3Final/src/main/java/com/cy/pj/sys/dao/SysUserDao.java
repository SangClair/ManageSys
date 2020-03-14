package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.entity.SysUser;

@Mapper
public interface SysUserDao {

	public List<SysUserDeptVo> findPageObjects(String name, Integer startIndex, Integer pageSize);

	public Integer getRowCount(String name);

	public Integer validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);
	
	public List<CheckBox> findObjects();
	
	public Integer insertObject(SysUser sysUser);
	
	public SysUserDeptVo findObjectById(Integer id);
	
	public Integer updateObject(SysUser sysUser);
	
	public SysUser findUserByUserName(String username);
}
