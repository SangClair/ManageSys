package com.cy.pj.sys.service;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.config.PaginationProperties;
import com.cy.pj.common.util.Assert;
import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysRole;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Autowired
	private PaginationProperties paginationProperties;
	
	@Override
	@RequiresPermissions("sys:role:view")
	public PageObject<SysRole> findObjects(String name, Integer pageCurrent) {
		int pageSize = paginationProperties.getPageSize();
		Assert.isArgumentAvailable((pageCurrent == null || pageCurrent < 0), "页码值不正确");
		Integer rowCount = sysRoleDao.getRowCount(name);
		Assert.isServiceVerified((rowCount == 0), "没有对应的记录");
		Integer startIndex = (pageCurrent - 1) * pageSize;
		List<SysRole> records = sysRoleDao.findPageObjects(name, startIndex, pageSize);
		PageObject<SysRole> pageObject = new PageObject<SysRole>(pageCurrent, pageSize, rowCount, records);
		return pageObject;
	}

	@Override
	@RequiresPermissions("sys:role:view")
	public Integer getRowCount(String name) {
		Integer rows = sysRoleDao.getRowCount(name);
		return rows;
	}

	@Override
	@RequiresPermissions("sys:role:delete")
	public Integer deleteObjectByRoleId(Integer id) {
		Assert.isArgumentAvailable(id == null || id < 0, "请至少选择一个角色");
		sysRoleMenuDao.deleteObjectByRoleId(id);
		sysUserRoleDao.deleteObjectByRoleId(id);
		int rows = sysRoleDao.deleteObjectByRoleId(id);
		return rows;
	}

	@Override
	@RequiresPermissions("sys:role:add")
	public Integer saveObject(SysRole sysRole, Integer[] menuIds) {
		Assert.isArgumentAvailable(sysRole == null, "保存对象不能为空");
		Assert.isArgumentAvailable(sysRole.getName() == null, "保存对象名字不能为空");
		Assert.isArgumentAvailable(menuIds == null || menuIds.length == 0, "必须为角色分配权限");
		sysRoleDao.insertObject(sysRole);
		Integer rows = sysRoleMenuDao.insertObjects(sysRole.getId(), menuIds);
		return rows;
	}

	@Override
	@RequiresPermissions("sys:role:view")
	public SysRoleMenuVo findObjectById(Integer id) {
		Assert.isArgumentAvailable(id == null || id < 1, "参数不正确");
		SysRoleMenuVo roleMenuVo = sysRoleDao.findObjectById(id);
		return roleMenuVo;
	}

	@Override
	@RequiresPermissions("sys:role:update")
	public Integer updateObject(SysRole sysRole, Integer[] menuIds) {
		Assert.isArgumentAvailable(sysRole == null, "信息不能为空");
		Assert.isArgumentAvailable(sysRole.getId() == null, "id值不能为空");
		int rows = sysRoleDao.updateObject(sysRole);
		Assert.isServiceVerified(rows == 0, "对象可能已经不存在");
		sysRoleMenuDao.deleteObjectByRoleId(sysRole.getId());
		sysRoleMenuDao.insertObjects(sysRole.getId(), menuIds);
		return rows;
	}

	@Override
	@RequiresPermissions("sys:role:view")
	public List<CheckBox> findObjects() {
		List<CheckBox> list = sysRoleDao.findObjects();
		Assert.isServiceVerified(list == null || list.size() == 0, "没有相关数据");
		return list;
	}
}
