package net.zjitc.shop.categorysecond.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import net.zjitc.shop.category.domain.Category;
import net.zjitc.shop.product.domain.Product;

public class CategorySecond implements Serializable {
	private int csid; // 主键
	private String csname; // 二级分类名称
	
	// 关联的一级分类（多方，与一级分类多对一关系）
	private Category category;
	
	// 与商品的一对多关系。表示二级分类对应的商品集合
	private Set<Product> products = new HashSet<Product>();
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
