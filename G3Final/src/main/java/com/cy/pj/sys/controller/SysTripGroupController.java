package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysTripGroup;
import com.cy.pj.sys.service.SysTripGroupService;

@RestController
@RequestMapping("/trip/")
public class SysTripGroupController {
    @Autowired
    private SysTripGroupService sysTripGroupService;
    @RequestMapping("doGroupList")
    public JsonResult dofindGroupList(String username,Integer pageCurrent){
        PageObject<SysTripGroup> allGroups = sysTripGroupService.findAllGroups(username,pageCurrent);
        return new JsonResult(allGroups);
    }

    @RequestMapping("doDeleteById")
    public JsonResult doDeleteById(Integer id){
        sysTripGroupService.deleteTripGroupById(id);
        return  new JsonResult("delete ok!");
    }
    @RequestMapping("doFindGroupById")
    public JsonResult doFindGroupById(Integer id){
        SysTripGroup tripGroup = sysTripGroupService.FindGroupById(id);
        return new JsonResult(tripGroup);
    }
    @RequestMapping("doUpdateGroup")
    public JsonResult doUpdateGroup(SysTripGroup entity){
        int i = sysTripGroupService.updateGroup(entity);
        return  new JsonResult("update ok!");
    }
    @RequestMapping("doInsertGroup")
    public JsonResult doInsertGroup(SysTripGroup entity){
        int i = sysTripGroupService.saveGroups(entity);
        return  new JsonResult("save ok!");
    }
}
