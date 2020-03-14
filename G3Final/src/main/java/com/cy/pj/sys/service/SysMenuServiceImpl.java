package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.Assert;
import com.cy.pj.common.vo.Node;
import com.cy.pj.common.vo.SysUserMenuVo;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysMenu;

@Service
public class SysMenuServiceImpl implements SysMenuService{

	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	public List<Map<String, Object>> findAllObjects() {
		List<Map<String, Object>> list = sysMenuDao.findAllObjects();
		Assert.isServiceVerified((list==null || list.size() == 0), "没有相关记录");
		return list;
	}

	@Override
	public Integer deleteObject(Integer id) {
		Assert.isArgumentAvailable(id==null || id < 1, "id值无效");
		System.out.println(id);
		int childCount = sysMenuDao.getChildCount(id);
		Assert.isServiceVerified(childCount > 0, "请先删除子元素");
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		int rows = sysMenuDao.deleteObject(id);
		Assert.isServiceVerified(rows == 0, "记录可能已经不存在");
		return rows;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> list =  sysMenuDao.findZtreeMenuNodes();
		Assert.isServiceVerified(list == null || list.size() == 0, "可能没有相关记录");
		return list;
	}

	@Override
	public Integer saveObject(SysMenu sysMenu) {
		Assert.isArgumentAvailable(sysMenu == null, "保存对象不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysMenu.getName()), "保存对象菜单名不能为空");

		Integer rows = null;
		try {
			rows = sysMenuDao.insertObject(sysMenu);
		} catch (Throwable e) {
			throw new ServiceException("保存失败");
		}
		return rows;
	}

	@Override
	public Integer updateObject(SysMenu sysMenu) {
		Assert.isArgumentAvailable(sysMenu == null, "保存对象不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysMenu.getName()), "保存对象菜单名不能为空");

		Integer rows = null;
		try {
			rows = sysMenuDao.updateObject(sysMenu);
		} catch (Throwable e) {
			throw new ServiceException("保存失败");
		}
		return rows;
	}

	@Override
	public List<SysUserMenuVo> findUserMenus(Integer userId) {
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userId);
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds.toArray(new Integer[] {}));
		List<SysUserMenuVo> list = sysMenuDao.findUserMenus(menuIds.toArray(new Integer[] {}));
		return list;
	}


}
