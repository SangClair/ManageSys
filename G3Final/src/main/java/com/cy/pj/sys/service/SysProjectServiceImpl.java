package com.cy.pj.sys.service;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.config.PaginationProperties;
import com.cy.pj.common.util.Assert;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysCategoryProject;
import com.cy.pj.sys.dao.SysGroupDao;
import com.cy.pj.sys.dao.SysProjectDao;
import com.cy.pj.sys.dao.SysTripDao;
import com.cy.pj.sys.entity.SysProject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class SysProjectServiceImpl implements SysProjectService{

	@Autowired
	SysProjectDao sysProjectDao;
	
	@Autowired
	SysGroupDao sysGroupDao;
	
	@Autowired
	PaginationProperties paginationProperties;
	
	@Autowired
	SysTripDao sysTripDao;
	@Override
	@RequiresPermissions("sys:project:view")
	public PageObject<SysCategoryProject> findPageObject(String name, Integer pageCurrent) {
		Integer pageSize = paginationProperties.getPageSize();
		Assert.isArgumentAvailable((pageCurrent == null || pageCurrent < 0), "页码值不正确");
		Integer startIndex = (pageCurrent - 1) * pageSize;
		Page<SysCategoryProject> page = PageHelper.startPage(pageCurrent, pageSize);
		List<SysCategoryProject> list = sysProjectDao.findAllProjects(name, startIndex, pageSize);
		PageObject<SysCategoryProject> pageObject = new PageObject<SysCategoryProject>(pageCurrent, pageSize,(int) page.getTotal(), list);
		return pageObject;
	}
	
	@Override
	@RequiresPermissions("sys:project:view")
	public PageObject<SysProject> findProjectsByParentId(Integer parentId, Integer pageCurrent) {
		Integer pageSize = paginationProperties.getPageSize();
		Assert.isArgumentAvailable((pageCurrent == null || pageCurrent < 0), "页码值不正确");
		Integer startIndex = (pageCurrent - 1) * pageSize;
		Page<SysCategoryProject> page = PageHelper.startPage(pageCurrent, pageSize);
		List<SysProject> list = sysProjectDao.findProjectsByParentId(parentId, startIndex, pageSize);
		PageObject<SysProject> pageObject = new PageObject<SysProject>(pageCurrent, pageSize,(int) page.getTotal(), list);
		return pageObject;
	}

	@Override
	@RequiresPermissions("sys:project:add")
	public Integer saveObject(SysProject sysProject) {
		Assert.isArgumentAvailable(sysProject == null, "保存对象不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getName()), "保存项目名不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getMinMembers()), "项目最少团员不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getParentId()), "必须选择所属类目不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getMaxMembers()), "项目最大团员不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getResume()), "项目简介不能为空");
		Integer rows = sysProjectDao.insertObject(sysProject);
		Assert.isServiceVerified(rows == null || 0 == rows, "保存失败");
		return rows;
	}

	@Override
	@RequiresPermissions("sys:project:view")
	public PageObject<SysProject> doFindProjects(String name, Integer pageCurrent) {
		Integer pageSize = paginationProperties.getPageSize();
		Assert.isArgumentAvailable((pageCurrent == null || pageCurrent < 0), "页码值不正确");
		Integer startIndex = (pageCurrent - 1) * pageSize;
		Page<SysCategoryProject> page = PageHelper.startPage(pageCurrent, pageSize);
		List<SysProject> list = sysProjectDao.doFindProjects(name, startIndex, pageSize);
		PageObject<SysProject> pageObject = new PageObject<SysProject>(pageCurrent, pageSize,(int) page.getTotal(), list);
		return pageObject;
	}

	@Override
	@RequiresPermissions("sys:project:view")
	public SysCategoryProject findProjectById(Integer id) {
		Assert.isArgumentAvailable(id == null || id < 1, "id非法");
		SysCategoryProject project = sysProjectDao.findCategoryProjectById(id);
		Assert.isServiceVerified(project == null, "该旅游项目可能已经不存在");
		return project;
	}

	@Override
	@RequiresPermissions("sys:project:update")
	public Integer updateProject(SysProject sysProject) {
		Assert.isArgumentAvailable(sysProject == null, "保存对象不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getName()), "保存项目名不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getMinMembers()), "项目最少团员不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getParentId()), "必须选择所属类目不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getMaxMembers()), "项目最大团员不能为空");
		Assert.isArgumentAvailable(StringUtils.isEmpty(sysProject.getResume()), "项目简介不能为空");
		int rows = sysProjectDao.updateProject(sysProject);
		Assert.isServiceVerified(rows == 0, "保存失败");
		return rows;
	}

	@Override
	@RequiresPermissions("sys:project:delete")
	public Integer deleteProject(Integer id) {
		Assert.isArgumentAvailable(id == null || 0 == id, "参数非法");
		int count = sysTripDao.FindGroupCountById(id);
		Assert.isServiceVerified(count != 0, "请先删除团目下的相关信息");
		Integer rows = sysProjectDao.deleteProject(id);
		Assert.isServiceVerified(rows == null || 0 == rows, "删除失败");
		return rows;
	}
	
}
