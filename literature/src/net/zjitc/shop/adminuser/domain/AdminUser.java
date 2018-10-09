package net.zjitc.shop.adminuser.domain;

//实体类：对应 管理员表。与数据库admin表字段一致
public class AdminUser {
	private int uid;
	private String username;
	private String password;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AdminUser() {
		super();
	}
	
	public AdminUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
