package net.zjitc.shop.adminuser.action;

import net.zjitc.shop.adminuser.domain.AdminUser;
import net.zjitc.shop.adminuser.service.AdminUserService;
import net.zjitc.shop.user.domain.Author;
import net.zjitc.shop.user.domain.User;
import net.zjitc.shop.user.service.UserService;
import net.zjitc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	
	/*
	 * 实现ModelDriven<AdminUser>拦截器，会自动将model
	 */
	// 自动接收用户输入信息
	private AdminUser adminUser = new AdminUser();

	@Override
	public AdminUser getModel() {
		return adminUser;
	}
	
	private AdminUserService adminUserService;

	public AdminUserService getAdminUserService() {
		return adminUserService;
	}
	
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	// 接收页面上传递的uid
	private int uid;

	// 分页用到的数据：page（JSP页面传递的），limit 自定义
	private int page; // 当前页
	private int limit=20; // 一页的记录数
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// 登陆操作
	public String login() {
		/*
		 * 1、接收用户输入的信息(ModelDriven)
		 * 2、通过业务层方法来判断账号密码信息是否正确
		 * 		正确：把用户信息保存在session，返回字符串	loginSuccess
		 * 		错误：把用户信息保存在request，返回字符串	loginFail
		 */
		// 2、调用业务层进行判断，返回值
		AdminUser user = adminUserService.query(adminUser.getUsername(), adminUser.getPassword());
		// 根据返回值判断成功与失败
		if(user == null) { // 失败：保存错误信息
			this.addActionError("用户名或密码错误！");
			return "loginFail";
		} else { // 成功：账号信息保存session
			ActionContext.getContext().getSession().put("adminuser", user);
			return "loginSuccess";
		}
	}
	
	/*
	 * 分页查询用户列表：只查询一页数据
	 */
	public String findAllUser() {
		/*
		 * 1、通过业务层方法查询所有用户信息（用到userService）
		 * 2、将查询出的数据放到对象栈（或者Map，比如request域），以便jsp页面使用
		 
		List<User> list = userService.findAllUser();
		ActionContext.getContext().put("list", list);*/
		
		/*
		 * 1、调用业务层方法获得一页二级分类
		 * 2、结果保存在对象栈，以供JSP页面
		 */
		PageBean<User> pageBean = userService.findPageList(page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAllUser";
	}
	
	/*
	 * 分页查询作者列表：只查询一页数据
	 */
	public String findAllAuthor() {
		/*
		 * 1、调用业务层方法获得一页二级分类
		 * 2、结果保存在对象栈，以供JSP页面
		 */
		PageBean<Author> pageBean = userService.findPageAuthor(page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAllAuthor";
	}

}
