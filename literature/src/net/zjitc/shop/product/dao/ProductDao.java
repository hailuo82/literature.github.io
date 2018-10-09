package net.zjitc.shop.product.dao;

import java.util.List;


import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.zjitc.shop.adminuser.domain.AdminUser;
import net.zjitc.shop.categorysecond.domain.CategorySecond;
import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.utils.PageBean;
import net.zjitc.shop.utils.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport {
	/*
	 * 查询商品列表
	 */
	public List<Product> findAllProduct() {
		String hql = " from Product";
		return this.getHibernateTemplate().find(hql);
	}

	/*
	 * 查询分页数据
	 */
	public PageBean<Product> list(int page, int limit) {
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
		String hql = "select count(*) from Product";
		Long i = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = i.intValue();
		
		// 查询1页数据
		hql = "from Product";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, (page-1)*limit, limit);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(page, limit, totalCount, list);
	}

	/*
	 * 添加商品
	 */
	public void add(Product product) {
		this.getHibernateTemplate().save(product);
	}

	/*
	 *  根据pid查询对象，用于回显
	 */
	public Product findById(int pid) {
		return (Product) this.getHibernateTemplate().get(Product.class, pid);
	}

	/*
	 * 修改
	 */
	public void edit(Product product) {
		this.getHibernateTemplate().update(product);
	}

	/*
	 * 删除
	 */
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	/*
	 * 根据二级分类，得到商品的数目
	 */
	public int getCountById(CategorySecond categorySecond) {
		String hql = "select count(*) from Product where categorySecond=?";
		Long i = (Long) this.getHibernateTemplate().find(hql, new Object[]{categorySecond}).listIterator().next();
		int c = i.intValue();
		return c;
	}

	/*
	 * 利用分页查询第1条热门商品
	 */
	public PageBean<Product> findHotProduct() {
		// 记录数totalCount
		String hql = "SELECT count(*) FROM Product WHERE is_hot=1";
		Long c = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = c.intValue();
		
		// 获取一页数据list
		hql = " FROM Product order by popularity desc";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, 0, 1);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(1, 1, totalCount, list);
	}

	/*
	 * 利用分页查询第2~4条热门商品
	 */
	public PageBean<Product> findSecondHotProduct() {
		// 记录数totalCount
		String hql = "SELECT count(*) FROM Product WHERE is_hot=1";
		Long c = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = c.intValue();
		
		// 获取一页数据list
		hql = " FROM Product order by popularity desc";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, 1, 3);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(1, 3, totalCount, list);
	}

	/*
	 * 利用分页查询第10~12条热门商品
	 */
	public PageBean<Product> findHotRightProduct() {
		// 记录数totalCount
		String hql = "SELECT count(*) FROM Product WHERE is_hot=1";
		Long c = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = c.intValue();
		
		// 获取一页数据list
		hql = " FROM Product order by popularity desc";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, 9, 3);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(1, 3, totalCount, list);
	}

	/*
	 * 利用分页查询第1条最新商品
	 */
	public PageBean<Product> findNewProduct() {
		// 记录数totalCount
		String hql = "select count(*) from Product";
		Long c = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = c.intValue();
		
		// 获取一页数据list
		hql = "from Product order by pdate DESC";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, 0, 1);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(1, 1, totalCount, list);
	}
	
	/*
	 * 利用分页查询第2~4条最新商品
	 */
	public PageBean<Product> findSecondNewProduct() {
		// 记录数totalCount
		String hql = "select count(*) from Product";
		Long c = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = c.intValue();
		
		// 获取一页数据list
		hql = "from Product order by pdate DESC";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, 1, 3);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(1, 3, totalCount, list);
	}
	
	/*
	 * 利用分页查询第10~12条最新商品
	 */
	public PageBean<Product> findNewRightProduct() {
		// 记录数totalCount
		String hql = "select count(*) from Product";
		Long c = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = c.intValue();
		
		// 获取一页数据list
		hql = "from Product order by pdate DESC";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, 9, 3);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(1, 3, totalCount, list);
	}

	/*
	 * 男频排行榜
	 */
	public PageBean<Product> findManProduct() {// 记录数totalCount
		String hql = "select count(*) from Product p where p.categorySecond.csid=6 or p.categorySecond.csid=36";
		Long c = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = c.intValue();
		
		// 获取一页数据list
		hql = "from Product p where p.categorySecond.csid=6 or p.categorySecond.csid=36 order by popularity desc";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, 0, 10);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(1, 10, totalCount, list);
	}
	
	/*
	 * 女频排行榜
	 */
	public PageBean<Product> findWomanProduct() {
		String hql = "select count(*) from Product p where p.categorySecond.csid=37 or p.categorySecond.csid=38";
		Long c = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = c.intValue();
		
		// 获取一页数据list
		hql = "from Product p where p.categorySecond.csid=37 or p.categorySecond.csid=38 order by popularity desc";
		PageHibernateCallback<Product> callback = new PageHibernateCallback<Product>(hql, null, 0, 10);
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Product>(1, 10, totalCount, list);
	}

	// 根据一级分类id查找分页商品
	public PageBean<Product> findByCid(int cid, int page, int limit) {
        String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
        Long c=(Long) this.getHibernateTemplate().find(hql, new Object[]{cid}).listIterator().next();
		int totalCount=c.intValue();
		
		hql="from Product p where p.categorySecond.category.cid=?";
		PageHibernateCallback<Product> callback=new PageHibernateCallback<Product>(hql, new Object[]{cid}, (page-1)*limit, limit);
		List<Product> list=(List<Product>) this.getHibernateTemplate().execute(callback);
        
		return new PageBean<Product>(page, limit, totalCount, list);
	}

	// 根据一级分类id查找二级分类
	public List<Product> findCSList(int cid) {
		String hql = "from CategorySecond cs where cs.cid=?";
		return this.getHibernateTemplate().find(hql);
	}

	// 根据二级分类id查找分页商品
	public PageBean<Product> findByCsid(int csid, int page, int limit) {
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
        Long c=(Long) this.getHibernateTemplate().find(hql, new Object[]{csid}).listIterator().next();
		int totalCount=c.intValue();
		
		hql="from Product p where p.categorySecond.csid=?";
		PageHibernateCallback<Product> callback=new PageHibernateCallback<Product>(hql, new Object[]{csid}, (page-1)*limit, limit);
		List<Product> list=(List<Product>) this.getHibernateTemplate().execute(callback);

		return new PageBean<Product>(page, limit, totalCount, list);
	}

	// 根据商品id查看商品详情
	public Product findByPid(Integer pid) {
		Product product=(Product) this.getHibernateTemplate().get(Product.class, pid);
		return product;
	}

	// 根据商品名称查看商品详情
	public Product findByName(String pname) {
		String hql = "from Product where pname=?";
		List<Product> list = this.getHibernateTemplate().find(hql, new Object[]{pname});
		if(list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/*
	 * 根据pid查询商品信息
	 */
	public List<Product> findProductByPid(int pid) {
		String hql = "from Product where pid=?";
		return this.getHibernateTemplate().find(hql, pid);
	}
	
}
