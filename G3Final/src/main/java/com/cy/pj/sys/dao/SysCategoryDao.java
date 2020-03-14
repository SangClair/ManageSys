package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysCategory;

@Mapper
public interface SysCategoryDao {
	
	public SysCategory findCategoryById(Integer id);
	
	public List<SysCategory> findAllCategories();
	
	public List<Node> findZtreeCategoryNodes();
	

	List<Map<String, Object>> findObjects();

	@Select("select id, categoryName name, parentId from sys_categories")
	List<Node> findZtreeMenuNodes();

	int insertObject(SysCategory entity);

	@Update("update sys_categories set categoryName=#{categoryName},modifiedUser=#{modifiedUser}, modifiedTime=now() where id=#{id}")
	int updateObject(SysCategory entity);
	
	@Delete("delete from sys_categories where id=#{id}")
	int deleteObject(Integer id);
	
	@Select("select count(*) from sys_categories where parentId=#{id}")
	int getChildCount(Integer id);
	
	@Select("select count(*) from sys_projects where parentId=#{id}")
	int getProjectCount(Integer id);

	@Select("select * from sys_categories where parentId = #{parentId}")
	public List<SysCategory> FindChildCategoriesByParentId(Integer parentId);
}
