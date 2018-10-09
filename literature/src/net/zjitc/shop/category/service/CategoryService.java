package net.zjitc.shop.category.service;

import java.util.List;

import net.zjitc.shop.category.dao.CategoryDao;
import net.zjitc.shop.category.domain.Category;
import net.zjitc.shop.categorysecond.dao.CategorySecondDao;
import net.zjitc.shop.utils.CategoryException;

public class CategoryService {
	// 注入Dao
	private CategoryDao categoryDao;
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	//注入CategorySecondDao
	private CategorySecondDao categorySecondDao;
	public CategorySecondDao getCategorySecondDao() {
		return categorySecondDao;
	}
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
	// 查询
	public List<Category> findAllCategory() {
		return categoryDao.findAllCategory();
	}
	
	// 添加
	public void add(Category category) {
		categoryDao.add(category);
	}

	// 根据cid查询对象，用于回显
	public Category findById(int cid) {
		return categoryDao.findById(cid);
	}
	// 修改
	public void edit(Category category) {
		categoryDao.edit(category);
	}

	// 删除
	public void delete(Category category) throws CategoryException {
		/*
		 * 1、抛出自定义异常
		 * 2、判断该分类下的二级分类数目
		 * 		若>0，则抛出异常
		 * 3、调用Dao层方法执行delete操作
		 */
		int c = categorySecondDao.getCountById(category); // 判断category分类下的二级分类数目
		if(c>0) {
			throw new CategoryException("该分类下还有二级分类，不能删除！");
		} else {
			categoryDao.delete(category);
		}
	}
}
