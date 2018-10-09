package net.zjitc.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.zjitc.shop.order.domain.Order;
import net.zjitc.shop.utils.PageBean;
import net.zjitc.shop.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport {

	/*
	 * 查询所有订单列表
	 */
	public List<Order> findAllOrder() {
		String hql = " from Order";
		return this.getHibernateTemplate().find(hql);
	}

	/*
	 * 分页查询订单列表
	 */
	public PageBean<Order> findPageList(int page, int limit) {
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
		String hql = "select count(*) from Order";
		Long i = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = i.intValue();
		
		// 查询1页数据
		hql = "from Order";
		PageHibernateCallback<Order> callback = new PageHibernateCallback<Order>(hql, null, (page-1)*limit, limit);
		List<Order> list = (List<Order>) this.getHibernateTemplate().execute(callback);
		return new PageBean<Order>(page, limit, totalCount, list);
	}

	/*
	 * 按状态分页查询订单列表
	 */
	public PageBean<Order> findByState(int state, int page, int limit) {
		// 查询总记录数totalCount
		String hql = "select count(*) from Order";
		Long i = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = i.intValue();
		
		// 查询1页数据
		hql = "from Order where state=?";
		PageHibernateCallback<Order> callback = new PageHibernateCallback<Order>(hql, new Object[]{state}, (page-1)*limit, limit);
		List<Order> list = (List<Order>) this.getHibernateTemplate().execute(callback);
		return new PageBean<Order>(page, limit, totalCount, list);
	}

	/*
	 * 根据oid查询对象
	 */
	public Order findById(String oid) {
		return (Order) this.getHibernateTemplate().get(Order.class, oid);
	}

	/*
	 * 修改订单状态
	 */
	public void edit(Order order) {
		this.getHibernateTemplate().update(order);
	}

}
