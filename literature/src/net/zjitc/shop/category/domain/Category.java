package net.zjitc.shop.category.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import net.zjitc.shop.categorysecond.domain.CategorySecond;

public class Category implements Serializable {
	private int cid; // 主键，一级分类id
	private String cname; // 一级分类名称
	
	// 与二级分类的一对多关系。表示一级分类对应的二级分类集合
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
}
