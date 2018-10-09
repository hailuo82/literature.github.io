package net.zjitc.shop.user.service;

import java.util.List;

import net.zjitc.shop.user.dao.UserDao;
import net.zjitc.shop.user.domain.Author;
import net.zjitc.shop.user.domain.User;
import net.zjitc.shop.utils.PageBean;

public class UserService {
	// 注入
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 查询所有用户
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	/*
	 * 分页查询用户列表：只查询一页数据
	 */
	public PageBean<User> findPageList(int page, int limit) {
		return userDao.findPageList(page, limit);
	}

	/*
	 * 分页查询作者列表：只查询一页数据
	 */
	public PageBean<Author> findPageAuthor(int page, int limit) {
		return userDao.findPageAuthor(page, limit);
	}

	// 注册
	public void save(User user) throws UserException {
		/*
		 * 1、判断用户名是否存在
		 * 		若存在，则抛出异常
		 * 		若不存在，调用数据层方法完成注册
		 */
		User u = userDao.findByName(user.getUsername());
		if(u != null) {
			throw new UserException("用户名已存在！");
		} else {
			userDao.save(user);
		}
	}

	// 业务层激活方法
	public void active(String code) throws UserException {
		/*
		 * 1、根据传入的code，获得user对象（调用数据层方法）
		 * 2、若user为null，抛出异常：激活码无效
		 * 3、判断用户状态是否为激活，若已激活（state=1），则抛出异常：已激活，无需重复激活
		 * 4、正常情况，设置state为1，调用业务层方法完成更新
		 */
		User user = userDao.findByCode(code);
		if(user == null) {
			throw new UserException("激活码无效！");
		} else {
			if(user.getState() == 1) {
				throw new UserException("用户已激活，不能重复激活！");
			} else {
				user.setState(1);
				userDao.updateState(user);
			}
		}
	}

	// 业务层登陆方法
	public User login(String username, String password) throws UserException {
		/*
		 * 1、调用业务层方法完成查询（根据用户名，密码查询用户对象）
		 *   若用户不存在，则抛出异常：用户名或密码错误
		 *   若用户存在，则查询该用户的state是否为1（调用业务层方法完成查询）
		 *      若state为0，则抛出异常：尚未激活，请先到邮箱完成激活
		 *      否则返回User对象
		 */
		User user = userDao.find(username, password); // 根据用户名、密码查询
		if(user == null) {
			throw new UserException("用户名或密码不存在！");
		} else if(user.getState() == 0) {
				throw new UserException("尚未激活，请先到邮箱完成激活！");
		}
		return user;
	}

	// 业务层找回密码方法
	public User forget(String username, String email) throws UserException {
		/*
		 * 1、调用数据层方法完成查询操作
		 * 		若用户不存在，则抛出异常：用户名或邮箱错误
		 * 		返回User对象
		 */
		User user = userDao.findByNameEmail(username, email);
		if(user == null) {
			throw new UserException("用户名或邮箱错误");
		}
		return user;
	}
	
	/*
	 * 我的账户
	 */
	public User findPerson(String username) {
		return userDao.findPerson(username);
	}
	
	/*
	 * 个人设置:修改姓名、邮箱、省市、密码、手机
	 */
	public void updatePerson(User user) {
		userDao.updatePerson(user);
	}

	/*
	 * 根据uid查询用户
	 */
	public List<User> findUserById(int uid) {
		return userDao.findUserById(uid);
	}
	
}
