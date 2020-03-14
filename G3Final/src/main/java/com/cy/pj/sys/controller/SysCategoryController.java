package com.cy.pj.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysCategory;
import com.cy.pj.sys.service.SysCategoryService;

@RestController
@RequestMapping("/category/")
public class SysCategoryController {
	@Autowired
	SysCategoryService sysCategoryService;

	@RequestMapping("doFindAllCategories")
	public JsonResult doFindAllCategories() {
		List<SysCategory> list = sysCategoryService.findAllCategories();
		return new JsonResult(list);
	}

	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects() {
		return new JsonResult(sysCategoryService.findObjects());
	}
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysCategory entity) {
		sysCategoryService.saveObject(entity);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doFindZtreeCategoryNodes")
	public JsonResult dodoFindZtreeMenuNodes() {
		List<Node> list = sysCategoryService.findZtreeMenuNodes();
		return new JsonResult(list);
	}
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysCategory entity) {
		sysCategoryService.updateObject(entity);
		return new JsonResult("update ok");
	}
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObjects(Integer id) {
		sysCategoryService.deleteObject(id);
		return new JsonResult("删除成功");
	}
	
	@RequestMapping("doFindChildCategoriesByParentId")
	public JsonResult doFindChildCategoriesByParentId(Integer parentId) {
		return new JsonResult(sysCategoryService.doFindChildCategoriesByParentId(parentId));
	}
}
