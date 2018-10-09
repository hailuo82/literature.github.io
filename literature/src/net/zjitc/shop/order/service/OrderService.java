package net.zjitc.shop.order.service;

import java.util.List;

import net.zjitc.shop.order.dao.OrderDao;
import net.zjitc.shop.order.domain.Order;
import net.zjitc.shop.utils.PageBean;

public class OrderService {
	// 注入OrderDao
	private OrderDao orderDao;
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/*
	 * 查询所有订单列表
	 */
	public List<Order> findAllOrder() {
		return orderDao.findAllOrder();
	}
	
	/*
	 * 分页查询订单列表
	 */
	public PageBean<Order> findPageList(int page, int limit) {
		return orderDao.findPageList(page, limit);
	}
	
	/*
	 * 按状态分页查询订单列表
	 */
	public PageBean<Order> findByState(int state, int page, int limit) {
		return orderDao.findByState(state, page, limit);
	}
	
	/*
	 * 根据oid查询对象
	 */
	public Order findById(String oid) {
		return orderDao.findById(oid);
	}
	
	/*
	 * 修改订单状态
	 */
	public void edit(Order order) {
		orderDao.edit(order);
	}

}
