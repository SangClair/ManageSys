package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysBrand;

@Mapper
public interface SysBrandDao {
	
	//查询公司信息总记录
	int getRowCount(@Param("corporatename") String corporatename);
	
	//查询每页公司信息
	List<SysBrand> findPageObjects(@Param("corporatename")String corporatename,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	
	//根据id删除公司
	int deleteObjects(@Param("ids")Integer[] ids);
	
	//添加公司信息
	int insertObjects(SysBrand entity);
	
	//基于id查询公司信息
	SysBrand findObjectById(Integer id);
	
	//修改公司信息
	int updateObject(SysBrand entity);

}
