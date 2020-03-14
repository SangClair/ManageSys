package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.Node;
import com.cy.pj.common.vo.SysUserMenuVo;
import com.cy.pj.sys.entity.SysMenu;


public interface SysMenuService {
	
	public List<Map<String, Object>> findAllObjects();
	
	public Integer deleteObject(Integer id);
	
	public List<Node> findZtreeMenuNodes();
	
	public Integer saveObject(SysMenu sysMenu);
	
	public Integer updateObject(SysMenu sysMenu);
	
	public List<SysUserMenuVo> findUserMenus(Integer userid);
}
