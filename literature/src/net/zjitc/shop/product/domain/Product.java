package net.zjitc.shop.product.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.zjitc.shop.categorysecond.domain.CategorySecond;
import net.zjitc.shop.order.domain.OrderItem;

public class Product implements Serializable {
	private int pid;
	private String pname;
	private String author;
	private String shop_price;
	private String image;
	private String pdesc;
	private Integer popularity; // 人气
	private int is_hot;
	private Date pdate;
	// 关联的二级分类（多方），与二级分类多对一关系
	private CategorySecond categorySecond;
	
	// 关联订单项，与订单项一对多的关系
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getShop_price() {
		return shop_price;
	}
	public void setShop_price(String shop_price) {
		this.shop_price = shop_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getPopularity() {
		return popularity;
	}
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	public int getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	
}
