package net.zjitc.shop.collect.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.zjitc.shop.user.domain.User;

public class Collect implements Serializable {
	private int ucid;
	private String pname;
	private String collecttime;
	
	// 关联用户，（多方）与用户多对一关系
	private User user;
	
	// 关联收藏项，与收藏项一对多的关系
	private Set<CollectItem> collectItems = new HashSet<CollectItem>();

	public int getUcid() {
		return ucid;
	}
	public void setUcid(int ucid) {
		this.ucid = ucid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCollecttime() {
		return collecttime;
	}
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<CollectItem> getCollectItems() {
		return collectItems;
	}
	public void setCollectItems(Set<CollectItem> collectItems) {
		this.collectItems = collectItems;
	}
}
