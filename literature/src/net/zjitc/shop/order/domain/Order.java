package net.zjitc.shop.order.domain;

import java.util.HashSet;
import java.util.Set;

import net.zjitc.shop.user.domain.User;

public class Order {
	private String oid;
	private double total;
	private String ordertime;
	private int state;
	private String name;
	private String phone;
	
	// 关联订单项，与订单项一对多的关系
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	// 关联用户，与用户多对一的关系
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
