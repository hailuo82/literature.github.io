package net.zjitc.shop.adminuser.dao;

import java.util.List;

import javax.annotation.Resource;

import net.zjitc.shop.adminuser.domain.AdminUser;

import org.hibernate.SessionFactory;
//import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public class AdminUserDao extends HibernateDaoSupport {
	
	/*private SessionFactory sessionFactory;*/
	

	@Transactional
	public AdminUser query(String username, String password) {
		String hql = " from AdminUser where username=? and password=?";
		
		/*AdminUser user = (AdminUser) sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, username)
				.setParameter(1, password)
				.uniqueResult();*/
		
		List<AdminUser> list = this.getHibernateTemplate().find(hql, new Object[]{username, password});
		if(list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
}
