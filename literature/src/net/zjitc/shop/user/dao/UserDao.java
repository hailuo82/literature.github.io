package net.zjitc.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.zjitc.shop.categorysecond.domain.CategorySecond;
import net.zjitc.shop.user.domain.Author;
import net.zjitc.shop.user.domain.User;
import net.zjitc.shop.utils.PageBean;
import net.zjitc.shop.utils.PageHibernateCallback;

public class UserDao extends HibernateDaoSupport {

	public List<User> findAllUser() {
		String hql = " from User";
		return this.getHibernateTemplate().find(hql);
	}

	// 按用户名查询
	public User findByName(String username) {
		String hql = "from User where username=?";
		List<User> list = this.getHibernateTemplate().find(hql, new Object[]{username});
		if(list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 保存用户
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	// 根据code查找用户
	public User findByCode(String code) {
		String hql = "from User where code=?";
		List<User> list = this.getHibernateTemplate().find(hql, new Object[]{code});
		if(list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 修改用户状态
	public void updateState(User user) {
		this.getHibernateTemplate().update(user);
	}

	// 根据用户名、密码查询
	public User find(String username, String password) {
		String hql = "from User where username=? and password=?";
		List<User> list = this.getHibernateTemplate().find(hql, new Object[]{username,password});
		if(list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 根据用户名、邮箱查询
	public User findByNameEmail(String username, String email) {
		String hql = "from User where username=? and email=?";
		List<User> list = this.getHibernateTemplate().find(hql, new Object[]{username,email});
		if(list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/*
	 * 分页查询用户列表：只查询一页数据
	 */
	public PageBean<User> findPageList(int page, int limit) {
		// 查询总记录数totalCount
		String hql = "select count(*) from User";
		Long i = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = i.intValue();
		
		// 查询1页数据
		hql = "from User";
		PageHibernateCallback<User> callback = new PageHibernateCallback<User>(hql, null, (page-1)*limit, limit);
		List<User> list = (List<User>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<User>(page, limit, totalCount, list);
	}

	/*
	 * 分页查询用户列表：只查询一页数据
	 */
	public PageBean<Author> findPageAuthor(int page, int limit) {
		// 查询总记录数totalCount
		String hql = "select count(*) from Author";
		Long i = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
		int totalCount = i.intValue();
		
		// 查询1页数据
		hql = "from Author";
		PageHibernateCallback<Author> callback = new PageHibernateCallback<Author>(hql, null, (page-1)*limit, limit);
		List<Author> list = (List<Author>) this.getHibernateTemplate().execute(callback);
		
		return new PageBean<Author>(page, limit, totalCount, list);
	}
	
	/*
	 * 我的账户
	 */
	public User findPerson(String username) {
		String hql = "from User where username=?";
		List<User> list = this.getHibernateTemplate().find(hql, new Object[]{username});
		if(list.size()>0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	/*
	 * 个人设置:修改姓名、邮箱、省市、密码、手机
	 */
	public void updatePerson(User user) {
		this.getHibernateTemplate().update(user);
	}

	/*
	 * 根据uid查询用户
	 */
	public List<User> findUserById(int uid) {
		String hql = "from User where uid=?";
		return this.getHibernateTemplate().find(hql, uid);
	}

}
