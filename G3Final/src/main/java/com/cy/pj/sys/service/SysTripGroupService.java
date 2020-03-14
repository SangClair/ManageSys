package com.cy.pj.sys.service;


import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysTripGroup;

public interface SysTripGroupService {
    PageObject<SysTripGroup> findAllGroups(String username, Integer pageCurrent);
    //根据id删除团队信息
    int deleteTripGroupById(Integer id);
    SysTripGroup FindGroupById(Integer id);
    int updateGroup(SysTripGroup entity);
    int saveGroups(SysTripGroup entity);
}
