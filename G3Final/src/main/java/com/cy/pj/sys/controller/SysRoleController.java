package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;

@RestController
@RequestMapping("/role/")
public class SysRoleController {

	@Autowired
	SysRoleService sysRoleService;
	
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String name,Integer pageCurrent) {
		return new JsonResult(sysRoleService.findObjects(name, pageCurrent));
	}
	
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysRoleService.deleteObjectByRoleId(id);
		return new JsonResult("delete ok");

	}
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysRole sysRole, Integer[] menuIds) {
		sysRoleService.saveObject(sysRole, menuIds);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysRoleService.findObjectById(id));
	}
	
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysRole sysRole, Integer[] menuIds) {
		sysRoleService.updateObject(sysRole, menuIds);
		return new JsonResult("update ok");
	}
	
	
	@RequestMapping("doFindRoles")
	public JsonResult doFindObject() {
		return new JsonResult(sysRoleService.findObjects());
	}
	
}
