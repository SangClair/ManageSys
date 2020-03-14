package com.cy.pj.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;

@RestController
@RequestMapping("/user/")
public class SysUserController {
	
	@Autowired
	SysUserService sysUserService;

	@RequestMapping("doLogin")
	public JsonResult doLogin(String username, String password, boolean isRememberMe) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		if(isRememberMe) token.setRememberMe(true);
		subject.login(token);
		return new JsonResult("loginOK");
	}
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
	}
	
	@RequestMapping("doValidById")
	public JsonResult doValidById(Integer id, Integer valid) {
		return new JsonResult(sysUserService.validById(id, valid, "admin"));
	}

	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysUser sysUser, Integer[] roleIds) {
		return new JsonResult(sysUserService.insertObject(sysUser, roleIds));
	}
	
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysUserService.findObjectById(id));
	}
	
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysUser sysUser, Integer[] roleIds) {
		sysUserService.updateObject(sysUser, roleIds);
		return new JsonResult("save ok");

	}
	
}
