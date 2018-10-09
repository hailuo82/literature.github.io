package net.zjitc.shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.zjitc.shop.category.domain.Category;
import net.zjitc.shop.categorysecond.domain.CategorySecond;
import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.utils.PageBean;
import net.zjitc.shop.utils.PageHibernateCallback;

public class CategorySecondDao extends HibernateDaoSupport {

	/*
	 * 查询二级分类列表
	 */
	public List<CategorySecond> list() {
		String hql = " from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}
	
	/*
	 * 查询分页数据
	 */
	public PageBean<CategorySecond> findPageList(int page, int limit) {
		/*
		 * 要查询出1页的PageBean对象，需要new PageBean<Product>(page, limit, total, list)
		 * 其中page和limit传递过来
		 * total 总记录数 直接查询数据库可以得到
		 * 关键是list  1页数据如何获得
		 * 1、查询总记录数
		 * 2、获得1页数据
		 * 3、返回PageBean对象
		 */
		// 查询总记录数totalCount
		String hql = "select count(*) from CategorySecond";
		Long i = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = i.intValue();
		
		// 查询1页数据
		hql = "from CategorySecond";
		PageHibernateCallback<CategorySecond> callback = new PageHibernateCallback<CategorySecond>(hql, null, (page-1)*limit, limit);
		List<CategorySecond> list = (List<CategorySecond>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<CategorySecond>(page, limit, totalCount, list);
	}


	/*
	 * 添加二级分类
	 */
	public void add(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	// 根据csid查询对象，用于回显
	public CategorySecond findById(int csid) {
		return (CategorySecond) this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	/*
	 * 修改二级分类
	 */
	public void edit(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}

	/*
	 * 删除
	 */
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
	}

	/*
	 * 根据一级分类，得到二级分类的数目
	 */
	public int getCountById(Category category) {
		String hql = "select count(*) from CategorySecond where category=?";
		Long i = (Long) this.getHibernateTemplate().find(hql, new Object[]{category}).listIterator().next();
		int c = i.intValue();
		return c;
	}
	
	// 根据页面传递的一级分类id查询一级分类名称
	public PageBean<CategorySecond> findCList(int cid) {
		
		// 查询一页数据
		String hql = "from Category c where c.cid=?";
		PageHibernateCallback<CategorySecond> callback = new PageHibernateCallback<CategorySecond>(hql, new Object[]{cid}, 0, 50);
		List<CategorySecond> list = (List<CategorySecond>) this.getHibernateTemplate().execute(callback);
		return new PageBean<CategorySecond>(1, 50, 1, list);
	}
	
	// 根据一级分类id查找二级分类
	public PageBean<CategorySecond> findCSList(int cid) {
		// 查询总记录数totalCount
		String hql = "select count(*) from CategorySecond cs where cs.category.cid=?";
		Long i = (Long) this.getHibernateTemplate().find(hql, cid).listIterator().next();
		int totalCount = i.intValue();
		
		// 查询一页数据
		hql = "from CategorySecond cs where cs.category.cid=?";
		PageHibernateCallback<CategorySecond> callback = new PageHibernateCallback<CategorySecond>(hql, new Object[]{cid}, 0, 50);
		List<CategorySecond> list = (List<CategorySecond>) this.getHibernateTemplate().execute(callback);
		return new PageBean<CategorySecond>(1, 50, totalCount, list);
	}
	
	// 根据二级分类id查询一级分类
	public PageBean<Category> findCListByCsid(int csid) {
		// 查询总记录数totalCount
		String hql = "select count(*) from Category c where c.categorySeconds.csid=?";
		Long i = (Long) this.getHibernateTemplate().find(hql, csid).listIterator().next();
		int totalCount = i.intValue();
		
		// 查询一页数据
		hql = "from Category c where c.categorySeconds.csid=?";
		PageHibernateCallback<Category> callback = new PageHibernateCallback<Category>(hql, new Object[]{csid}, 0, 1);
		List<Category> list = (List<Category>) this.getHibernateTemplate().execute(callback);
		return new PageBean<Category>(1, 1, totalCount, list);
	}

}
