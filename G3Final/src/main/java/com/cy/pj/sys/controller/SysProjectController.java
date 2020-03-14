package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysCategoryProject;
import com.cy.pj.sys.entity.SysProject;
import com.cy.pj.sys.service.SysProjectService;

@RequestMapping("/project/")
@RestController
public class SysProjectController {

	@Autowired
	SysProjectService sysProjectService;
	
	@RequestMapping("doFindAllProjects")
	public JsonResult doFindAllProjects(String name, Integer pageCurrent) {
		PageObject<SysCategoryProject> pageObject = sysProjectService.findPageObject(name, pageCurrent);
		return new JsonResult(pageObject);
	}
	
	@RequestMapping("doFindProjectsByParentId")
	public JsonResult doFindProjectsByParentId(Integer parentId, Integer pageCurrent) {
		PageObject<SysProject> pageObject = sysProjectService.findProjectsByParentId(parentId, pageCurrent);
		return new JsonResult(pageObject);
	}
	
	@RequestMapping("doSaveProject")
	public JsonResult doSaveObject(SysProject sysProject) {
		sysProjectService.saveObject(sysProject);
		return new JsonResult("保存项目成功");
	}
	
	@RequestMapping("doFindProjects")
	public JsonResult doFindProjects(String name, Integer pageCurrent) {
		return new JsonResult(sysProjectService.doFindProjects(name, pageCurrent));
	}
	
	@RequestMapping("doFindProjectById")
	public JsonResult doFindProjectById(Integer id) {
		SysCategoryProject project = sysProjectService.findProjectById(id);
		System.out.println(project);
		return new JsonResult(project);
	}
	
	@RequestMapping("doUpdateProject")
	public JsonResult doUpdateProject(SysProject sysProject) {
		return new JsonResult(sysProjectService.updateProject(sysProject));
	}
	
	@RequestMapping("doDeleteProject")
	public JsonResult doDeleteProject(Integer id ) {
		return new JsonResult(sysProjectService.deleteProject(id));
	}
}
