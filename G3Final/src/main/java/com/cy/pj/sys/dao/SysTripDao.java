package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.sys.entity.SysTripGroup;

@Mapper
public interface SysTripDao {
    //找到所有的团目信息
    List<SysTripGroup> findGroups(String username);
    //根据团目id进行删除
    int deleteTripGroupById(Integer id);
    //根据id查找
    SysTripGroup FindGroupById(Integer id);
    //update
    @Select("select count(*) from sys_groups where projectId = #{id}")
    int FindGroupCountById(Integer id);
    int updateGroup(SysTripGroup entity);
    //查找项目id
    int findProjectId(String username);
    //添加团目
    int insertGroups(SysTripGroup entity);
}
