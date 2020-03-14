package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.SysCategoryProject;
import com.cy.pj.sys.entity.SysProject;

@Mapper
public interface SysProjectDao {

	public List<SysCategoryProject> findAllProjects(@Param("name")String name,@Param("startIndex") Integer startIndex, @Param("pageSize")Integer pageSize);
	
	
	public List<SysProject> findProjectsByParentId(Integer parentId, Integer startIndex, Integer pageSize);
	
	public Integer insertObject(SysProject sysProject);
	
	public List<SysProject> doFindProjects(@Param("name")String name,@Param("startIndex") Integer startIndex, @Param("pageSize")Integer pageSize);

	public SysCategoryProject findCategoryProjectById(Integer id );

	public Integer updateProject(SysProject sysProject);
	
	public Integer deleteProject(Integer id);

	@Select("select id from sys_projects where name = #{projectName}")
	public int findProjectIdByName(String projectName);
}
