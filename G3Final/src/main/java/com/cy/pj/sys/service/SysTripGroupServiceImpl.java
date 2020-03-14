package com.cy.pj.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.config.PaginationProperties;
import com.cy.pj.common.util.Assert;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysProjectDao;
import com.cy.pj.sys.dao.SysTripDao;
import com.cy.pj.sys.entity.SysTripGroup;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class SysTripGroupServiceImpl implements SysTripGroupService {
    @Autowired
    private PaginationProperties paginationProperties;
    @Autowired
    private SysTripDao sysTripDao;
    @Autowired
    private SysProjectDao sysProjectDao;
    
    @Override
    public PageObject<SysTripGroup> findAllGroups(String username, Integer pageCurrent) {
        //1.参数校验
        if(pageCurrent==null||pageCurrent<1){
            throw new IllegalArgumentException("页码值不正确");
        }
        Assert.isArgumentAvailable(pageCurrent==null||pageCurrent<1,"页码值不正确");

        int pageSize=paginationProperties.getPageSize();//页面大小
        PageHelper.startPage(pageCurrent,pageSize);
        List<SysTripGroup> groups = sysTripDao.findGroups(username);
        //Assert.isServiceValid(groups==null||groups.size()==0,"暂无团队记录！");
        PageInfo<SysTripGroup> pageInfo = new PageInfo<>(groups);
        //Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records
        return new PageObject<>(pageCurrent, pageSize, (int)pageInfo.getTotal(),groups);
    }
    @Override
    public int deleteTripGroupById(Integer id) {
        int rows = sysTripDao.deleteTripGroupById(id);
        return rows;
    }

    @Override
    public SysTripGroup FindGroupById(Integer id) {
        SysTripGroup group = sysTripDao.FindGroupById(id);
        Assert.isServiceVerified(group==null,"此记录已经不存在！");
        return group;
    }

    @Override
    public int updateGroup(SysTripGroup entity) {
        int projectId = sysTripDao.findProjectId(entity.getProjectName());
        entity.setProjectId(projectId);
        int i = sysTripDao.updateGroup(entity);
        return i;
    }

    @Override
    public int saveGroups(SysTripGroup entity) {
        int projectId = sysProjectDao.findProjectIdByName(entity.getProjectName());
        entity.setProjectId(projectId);
        int row = sysTripDao.insertGroups(entity);
        return row;
    }
}
