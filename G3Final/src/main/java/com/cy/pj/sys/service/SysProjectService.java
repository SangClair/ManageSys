package com.cy.pj.sys.service;


import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysCategoryProject;
import com.cy.pj.sys.entity.SysProject;

public interface SysProjectService {

	public PageObject<SysCategoryProject> findPageObject(String name, Integer pageCurrent);

	public PageObject<SysProject> findProjectsByParentId(Integer parentId, Integer pageCurrent);
	
	public Integer saveObject(SysProject sysProject);
	
	public PageObject<SysProject> doFindProjects(String name, Integer pageCurrent);
	
	public SysCategoryProject findProjectById(Integer id);

	public Integer updateProject(SysProject sysProject);
	
	public Integer deleteProject(Integer id);
}
