package com.cy.pj.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.common.aspect.RequiredLog;
import com.cy.pj.common.config.PaginationProperties;
import com.cy.pj.common.util.Assert;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysUser;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false, timeout = 30, rollbackFor = Throwable.class )
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Autowired
	private PaginationProperties paginationProperties;

	@Override
	@RequiredLog(operation = "查找用户")
	@Transactional(readOnly = true)
	@RequiresPermissions("sys:user:view")
	public PageObject<SysUserDeptVo> findPageObjects(String name, Integer pageCurrent) {
		Assert.isArgumentAvailable((pageCurrent == null || pageCurrent < 0), "页码值不正确");
		int rowCount = sysUserDao.getRowCount(name);
		Assert.isServiceVerified((rowCount == 0), "没有对应的记录");
		int pageSize = paginationProperties.getPageSize();
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysUserDeptVo> list = sysUserDao.findPageObjects(name, startIndex, pageSize);
		PageObject<SysUserDeptVo> pageObject = new PageObject<>(pageCurrent, pageSize, rowCount, list);
		return pageObject;
	}

	@Override
	@RequiredLog(operation = "修改用户权限")
	@CacheEvict(value = "userCache", key = "#id")
	@RequiresPermissions("sys:user:update")
	public Integer validById(Integer id, Integer valid, String modifiedUser) {
		Assert.isArgumentAvailable(id == null || id < 1, "参数错误");
		Assert.isArgumentAvailable(valid != 0 && valid != 1, "状态码错误");
		int rows = sysUserDao.validById(id, valid, modifiedUser);
		Assert.isServiceVerified(rows != 1, "修改的用户可能已经不存在");
		return rows;
	}

	@Override
	@RequiredLog(operation = "新增用户")
	@RequiresPermissions("sys:user:add")
	public Integer insertObject(SysUser sysUser, Integer[] roleIds) {
		Assert.isArgumentAvailable(sysUser == null || sysUser.getUsername() == null || sysUser.getPassword() == null, "缺少参数");
		Assert.isArgumentAvailable(roleIds == null || roleIds.length == 0, "请至少选择一个角色");
		String source = sysUser.getPassword();
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5", source, salt, 1);
		sysUser.setSalt(salt);
		sysUser.setPassword(sh.toHex());
		int rows = sysUserDao.insertObject(sysUser);
		Assert.isServiceVerified(rows == 0, "记录可能已经不存在");
		sysUserRoleDao.insertObject(sysUser.getId(), roleIds);
		return rows;
	}

	@Override
	@RequiresPermissions("sys:user:view")
	@RequiredLog(operation = "指定查找用户")
	@Cacheable("userCache")
	@Transactional(readOnly = true)
	public Map<String, Object> findObjectById(Integer userId) {
		Assert.isArgumentAvailable((userId==null||userId<=0), "参数数据不合法,userId="+userId);
		SysUserDeptVo user=sysUserDao.findObjectById(userId);
		Assert.isServiceVerified(user==null, "此用户已经不存在");
		List<Integer> roleIds=sysUserRoleDao.findRolesByUserId(userId);
		Map<String,Object> map=new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}

	@Override
	@RequiredLog(operation = "修改用户")
	@RequiresPermissions("sys:user:update")
	@CacheEvict(value = "userCache", key = "#sysUser.id")
	public Integer updateObject(SysUser sysUser,Integer[] roleIds)  {
		Assert.isArgumentAvailable(sysUser == null || sysUser.getUsername() == null, "缺少参数");
		Assert.isArgumentAvailable(roleIds == null || roleIds.length == 0, "请至少选择一个角色");
		int rows = sysUserDao.updateObject(sysUser);
		Assert.isServiceVerified(rows == 0, "记录可能已经不存在");
		sysUserRoleDao.deleteObjectsByUserId(sysUser.getId());
		sysUserRoleDao.insertObject(sysUser.getId(), roleIds);
		return rows;
	}


	
}
