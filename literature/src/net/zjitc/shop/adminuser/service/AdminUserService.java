package net.zjitc.shop.adminuser.service;

import net.zjitc.shop.adminuser.dao.AdminUserDao;
import net.zjitc.shop.adminuser.domain.AdminUser;

public class AdminUserService {
	
	private AdminUserDao adminUserDao;
	
	public AdminUserDao getAdminUserDao() {
		return adminUserDao;
	}

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser query(String username, String password) {
		return adminUserDao.query(username, password);
	}

}
