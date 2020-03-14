package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.Node;
import com.cy.pj.common.vo.SysUserMenuVo;
import com.cy.pj.sys.entity.SysDept;
import com.cy.pj.sys.entity.SysMenu;

@Mapper
public interface SysMenuDao {

	public List<Map<String, Object>> findAllObjects();
	
	@Select("select count(*) from sys_menus where parentId = #{id}")
	public int getChildCount(Integer id);
	
	@Delete("delete from sys_menus where id = #{id}")
	public int deleteObject(Integer id);
	
	public List<Node> findZtreeMenuNodes();
	
	public Integer insertObject(SysMenu sysMenu);
	
	public Integer updateObject(SysMenu sysMenu);
	
	public SysDept findById(Integer id);
	
	public List<String> findPermissions(@Param("menuIds") Integer[] menuIds);
	
	public List<SysUserMenuVo> findUserMenus(Integer[] menuIds);
}
