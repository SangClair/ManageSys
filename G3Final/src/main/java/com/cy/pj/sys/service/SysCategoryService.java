package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysCategory;

public interface SysCategoryService {

	public List<SysCategory> findAllCategories();
	
	public List<Node> findZtreeCategoryNodes();
	
	List<Map<String,Object>>findObjects();

	List<Node> findZtreeMenuNodes();
	
	int saveObject(SysCategory entity);
	
	int updateObject(SysCategory entity);
	
	int deleteObject(Integer id);

	public List<SysCategory> doFindChildCategoriesByParentId(Integer parentId);
}

