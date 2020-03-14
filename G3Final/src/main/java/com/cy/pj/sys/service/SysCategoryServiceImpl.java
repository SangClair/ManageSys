package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.Assert;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.SysCategoryDao;
import com.cy.pj.sys.entity.SysCategory;

@Service
public class SysCategoryServiceImpl implements SysCategoryService{

	@Autowired
	SysCategoryDao sysCategoryDao;

	@Override
	public List<SysCategory> findAllCategories() {
		List<SysCategory> list = sysCategoryDao.findAllCategories();
		Assert.isServiceVerified(list == null || list.size() == 0, "类目数据不存在");
		return list;
	}

	@Override
	public List<Node> findZtreeCategoryNodes() {
		List<Node> list =  sysCategoryDao.findZtreeCategoryNodes();
		Assert.isServiceVerified(list == null || list.size() == 0, "可能没有相关记录");
		return list;
	}
	
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list = sysCategoryDao.findObjects();
		if (list == null || list.size() == 0)
			throw new ServiceException("没有对应的菜单信息");
		return list;

	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysCategoryDao.findZtreeMenuNodes();
	}

	@Override
	public int saveObject(SysCategory entity) {
		// 1.合法验证
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (entity.getCategoryName() == null || entity.getCategoryName().equals(""))
			throw new ServiceException("类目名不能为空");
		int rows;
		// 2.保存数据
		try {
			rows = sysCategoryDao.insertObject(entity);// 有可能网络中断,数据库连接没有了
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		// 3.返回数据
		return rows;
	}

	@Override
	public int updateObject(SysCategory entity) {
		int rows;
		rows = sysCategoryDao.updateObject(entity);
		return rows;
	}

	@Override
	public int deleteObject(Integer id) {
		if(id == null || id < 1)
			throw new ServiceException("id无效");
		int childCount = sysCategoryDao.getChildCount(id);
		if(childCount > 0)
			throw new ServiceException("请先删除子元素");
		int projectCount = sysCategoryDao.getProjectCount(id);
		if(projectCount > 0)
			throw new ServiceException("请先删除所属于此类的项目"); 
		int rows = sysCategoryDao.deleteObject(id);
		if(rows == 0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@Override
	public List<SysCategory> doFindChildCategoriesByParentId(Integer parentId) {
		Assert.isArgumentAvailable(parentId == null || parentId < 1, "参数非法");
		List<SysCategory> list= sysCategoryDao.FindChildCategoriesByParentId(parentId);
		return list;
	}
}
