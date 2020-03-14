package com.cy.pj.sys.service;



import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysBrand;

public interface SysBrandService {
	
	//查询分页信息
	PageObject<SysBrand> findPageObjects(@Param("corporatename")String corporatename,
									@Param("pageCurrent")Integer pageCurrent);
	
	
	//删除公司信息
	int deleteObjects(Integer[] ids);
	
	//添加公司信息
	int saveObjects(SysBrand entity);
	
	//基于id查询公司信息
	SysBrand findObjectById(Integer id);
	
	//修改公司信息
	int updateObject(SysBrand entity);

}
