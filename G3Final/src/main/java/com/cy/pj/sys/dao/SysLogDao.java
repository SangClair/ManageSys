package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.sys.entity.SysLog;

@Mapper
public interface SysLogDao {

	public Integer getRowCount(@Param("username") String username);
	
	public List<SysLog> findPageObject(@Param("username") String username, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);
	
	@Select("select * from sys_logs")
	public List<SysLog> findAllObject();
	
	public Integer deleteObjects(@Param("ids") Integer... ids);
	
	public Integer insertObject(SysLog sysLog);
	
	public List<SysLog> findLogsByIds(@Param("ids")Integer... ids);
}
