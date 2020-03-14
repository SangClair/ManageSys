package com.cy.pj.sys.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.common.vo.SysUserMenuVo;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysLogService;
import com.cy.pj.sys.service.SysMenuService;

@RequestMapping("/")
@Controller
public class PageController {

	@Autowired
	SysLogService sysLogService;

	@Autowired
	SysMenuService sysMenuService;
	
	@RequestMapping("doLoginUI")
	public String doLogin() {
		return "login";
	}

	@RequestMapping("doIndexUI")
	public String doIndexUI(Model model) {
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		String username = sysUser.getUsername();
		List<SysUserMenuVo> list = sysMenuService.findUserMenus(sysUser.getId());
		model.addAttribute("userMenus", list);
		model.addAttribute("username", username);
		return "starter";
	}

	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}

	/*
	 * @RequestMapping("log/log_list") public String doLogUI() { return
	 * "sys/log_list"; }
	 * 
	 * @RequestMapping("menu/menu_list") public String doMenuUI() { return
	 * "sys/menu_list"; }
	 */

	//rest风格(软件架构编码风格)的url
	//{}为rest表达式(内容为自己定义的变量)
	//@PathVariable用于告诉springmvc模块方法参数的值来自url
	@RequestMapping("{module}/{moduleUI}")
	public String doModuleUI(@PathVariable("moduleUI") String path) {
		return "sys/" + path;
	}
}
