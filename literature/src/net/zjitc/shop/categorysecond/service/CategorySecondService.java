package net.zjitc.shop.categorysecond.service;

import java.util.List;

import net.zjitc.shop.category.domain.Category;
import net.zjitc.shop.categorysecond.dao.CategorySecondDao;
import net.zjitc.shop.categorysecond.domain.CategorySecond;
import net.zjitc.shop.product.dao.ProductDao;
import net.zjitc.shop.utils.CategoryException;
import net.zjitc.shop.utils.PageBean;

public class CategorySecondService {
	// 注入Dao
	private CategorySecondDao categorySecondDao;
	public CategorySecondDao getCategorySecondDao() {
		return categorySecondDao;
	}
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
	// 注入productDao
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/*
	 * 查询二级分类列表
	 */
	public List<CategorySecond> list() {
		return categorySecondDao.list();
	}

	/*
	 * 查询分页数据：查询一页二级分类列表
	 */
	public PageBean<CategorySecond> findPageList(int page, int limit) {
		return categorySecondDao.findPageList(page, limit);
	}
	
	/*
	 * 添加二级分类
	 */
	public void add(CategorySecond categorySecond) {
		categorySecondDao.add(categorySecond);
	}
	
	// 根据csid查询对象，用于回显
	public CategorySecond findById(int csid) {
		return categorySecondDao.findById(csid);
	}
	
	/*
	 * 修改二级分类
	 */
	public void edit(CategorySecond categorySecond) {
		categorySecondDao.edit(categorySecond);
	}
	
	/*
	 * 删除
	 */
	public void delete(CategorySecond categorySecond) throws CategoryException {/*
		 * 1、抛出自定义异常
		 * 2、判断该分类下的商品数目
		 * 		若>0，则抛出异常
		 * 3、调用Dao层方法执行delete操作
		 */
		int c = productDao.getCountById(categorySecond); // 判断二级分类下的商品数目
		if(c>0) {
			throw new CategoryException("该分类下还有商品，不能删除！");
		} else {
			categorySecondDao.delete(categorySecond);
		}
	}
	
	// 根据页面传递的一级分类id查询一级分类名称
	public PageBean<CategorySecond> findCList(int cid) {
		return categorySecondDao.findCList(cid);
	}
	
	// 根据一级分类id查找二级分类
	public PageBean<CategorySecond> findCSList(int cid) {
		return categorySecondDao.findCSList(cid);
	}
	
	// 根据二级分类id查询一级分类
	public PageBean<Category> findCListByCsid(int csid) {
		return categorySecondDao.findCListByCsid(csid);
	}

}
