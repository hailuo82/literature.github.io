package net.zjitc.shop.order.domain;

import net.zjitc.shop.product.domain.Product;

public class OrderItem {
	private int itemid;
	private int count;
	private double subtotal;
	private int osatate;
	
	// 关联商品，与商品的多对一关系
	private Product product;
	
	// 关联订单，与订单的多对一关系
	private Order order;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getOsatate() {
		return osatate;
	}
	public void setOsatate(int osatate) {
		this.osatate = osatate;
	}
}
