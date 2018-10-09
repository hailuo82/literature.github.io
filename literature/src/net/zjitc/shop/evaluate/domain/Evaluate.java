package net.zjitc.shop.evaluate.domain;

import java.io.Serializable;
import java.util.Date;

import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.user.domain.User;

public class Evaluate implements Serializable {
	private int eid;// 主键
	private String title;//评价主题(好评，中评，差评)
	private String content;// 评价内容
	private Date date;//评价时间
	
	private User user;// 关联的用户，与用户多对一的关系
	private Product product;// 关联的商品，与商品多对一的关系
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
