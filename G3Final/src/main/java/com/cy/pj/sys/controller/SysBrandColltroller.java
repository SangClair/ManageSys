package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysBrand;
import com.cy.pj.sys.service.SysBrandService;

@RestController
@RequestMapping("/brand/")
public class SysBrandColltroller {
	
	@Autowired
	private SysBrandService sysBrandService;
//===========================================================================================
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String corporatename ,Integer pageCurrent) {
		return new JsonResult(sysBrandService.findPageObjects(corporatename, pageCurrent)) ;
	}
//=======================================================================================	
	@RequestMapping("doDeleteObjects")
	public JsonResult doDeleteObjects(Integer[] ids) {
		sysBrandService.deleteObjects(ids);
		return new JsonResult("删除成功");
	}
//============================================================================================
	@RequestMapping("doSaveObjects")
	public JsonResult doSaveObjects(SysBrand entity) {
		sysBrandService.saveObjects(entity);
		return new JsonResult("添加成功");
	}
//========================================================================================
	@RequestMapping("doFindObjectById")
	public JsonResult dofindObjectById(Integer id) {
		return new JsonResult(sysBrandService.findObjectById(id));
	}
	
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysBrand entity) {
		sysBrandService.updateObject(entity);
		return new JsonResult("修改成功");
	}
	
	
}
