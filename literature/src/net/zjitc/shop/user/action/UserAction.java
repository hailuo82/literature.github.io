package net.zjitc.shop.user.action;

import java.util.List;
import java.util.UUID;

import net.zjitc.shop.user.domain.User;
import net.zjitc.shop.user.service.UserException;
import net.zjitc.shop.user.service.UserService;
import net.zjitc.shop.utils.MailUtils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	// 模型（获取用户输入）
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	// 注入Service
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	// 接收输入的验证码
	private String validatecode;
	public String getValidatecode() {
		return validatecode;
	}
	public void setValidatecode(String validatecode) {
		this.validatecode = validatecode;
	}
	
	/*
	 * 注册界面
	 */
	public String registUI() {
		return "registUI";
	}

	/*
	 * 注册
	 */
	public String regist() {
		/*
		 * 1、判断验证码是否正确（用户输入的验证码与session中保存的验证码是否一致）
		 *    若不一致，保存错误信息，返回注册页面（JSP显示错误信息）
		 * 2、自动接收页面输入信息，封装在model
		 * 3、补全2个字段：state和code
		 * 4、调用业务层方法完成注册
		 *   正常执行，发送邮件, 保存提示信息，返回信息提示页面
		 *   异常，保存异常信息,返回注册页面
		 */
		String vcode = (String) ActionContext.getContext().getSession().get("validatecode");
		if(!validatecode.equalsIgnoreCase(vcode)) {
			this.addFieldError("registcodefail", "验证码错误！");
			return "registUI";
		}
		
		user.setState(0); // 0代表未激活，1代表已激活
		String c = UUID.randomUUID().toString() + UUID.randomUUID().toString();
		user.setCode(c); // 补全code
		
		try { // 调用业务层方法完成注册
			userService.save(user);
			this.addActionMessage("注册成功！激活码已发送到您的邮箱，请激活后登陆！");
			MailUtils.sendMail(user); // 发邮件
		} catch (UserException e) {
			this.addActionError(e.getMessage());
			return "msg";
		}
		
		return "msg";
	}
	
	/*
	 * 激活
	 */
	public String active() {
		/*
		 * 1、得到传入的code(setter/getter、request.getP...、model)
		 * 2、调用业务层方法完成激活
		 *   	正常情况，保存成功提示信息，返回信息提示页面
		 *   	异常情况，保存异常信息，返回信息提示页面
		 */
		try {
			userService.active(user.getCode());
			this.addActionMessage("激活成功！");
		} catch (UserException e) {
			this.addActionError(e.getMessage());
			return "msg";
		}
		return "msg";
	}

	/*
	 * 登陆界面
	 */
	public String loginUI() {
		return "loginUI";
	}
	
	/*
	 * 登陆
	 */
	public String login() {
		/*
		 * 1、判断验证码是否正确（session中的验证码与用户输入的是否一致）
		 *   若不一致，保存错误提示信息，返回到登陆页面
		 *   否则：调用业务层方法完成登陆功能（账号密码自动封装在model）
		 *      正常情况，将用户保存在session，重定向到首页
		 *      异常情况，保存错误信息，返回登陆页面
		 */
		String vcode = (String) ActionContext.getContext().getSession().get("validatecode");
		if(!validatecode.equalsIgnoreCase(vcode)) {
			this.addFieldError("logincodefail", "验证码错误！");
			return "loginUI";
		}
		
		try {
			User u = userService.login(user.getUsername(), user.getPassword());
			ActionContext.getContext().getSession().put("session_user", u);
		} catch (UserException e) {
			this.addActionError(e.getMessage());
			return "loginUI";
		}
		return "redirect"; // 登陆成功，重定向到首页
	}
	
	/*
	 * 忘记密码页面
	 */
	public String forgetUI() {
		return "forgetUI";
	}
	
	/*
	 * 找回密码
	 */
	public String forget() {
		/*
		 * 1、判断验证码是否正确（session中的验证码与用户输入的是否一致）
		 *   若不一致，保存错误提示信息，返回到忘记密码页面
		 *   否则：调用业务层方法完成查找用户密码功能
		 *      异常情况：保存异常信息，返回到忘记密码页面
		 *      正常情况：发送邮件给用户，保存提示信息，返回信息提示页面
		 */
		String vcode = (String) ServletActionContext.getRequest().getSession().getAttribute("validatecode");
		if(!validatecode.equalsIgnoreCase(vcode)) {
			this.addFieldError("forgetcodefail", "验证码错误"); // 给一个字段（属性）添加错误信息
			return "forgetUI";
		}
		try {
			User u = userService.forget(user.getUsername(), user.getEmail());
			MailUtils.sendMail(u);
			this.addActionMessage("密码发送成功，请到邮箱查收！");
		} catch (UserException e) {
			this.addFieldError("login_fail", e.getMessage());
			return "forgetUI";
		}
		return "msg";
	}
	
	/*
	 * 退出
	 */
	public String exit() {
		/*
		 * 1、将保存在session中的用户清空
		 */
		ActionContext.getContext().getSession().remove("session_user");
		return "redirect";
	}
	
	/*
	 * 个人中心页面
	 */
	public String personUI() {
		return "personUI";
	}
	
	/*
	 * 我的账户
	 */
	public String person() {
		User user = (User) ActionContext.getContext().getSession().get("session_user");
		String username = user.getUsername();
		User personuser = userService.findPerson(username);
		ActionContext.getContext().put("person_user", personuser);
		return "person";
	}
	
	/*
	 * 个人设置页面
	 */
	public String personSetUI() {
		User user = (User) ActionContext.getContext().getSession().get("session_user");
		String username = user.getUsername();
		User personuser = userService.findPerson(username);
		ActionContext.getContext().getSession().put("person_user", personuser);
		return "personSetUI";
	}
	
	/*
	 * 个人设置:修改姓名、邮箱、省市
	 */
	public String personSet() {
		try {
			User person = (User) ActionContext.getContext().getSession().get("person_user");
			user.setUid(person.getUid());
			user.setUsername(person.getUsername());
			user.setPassword(person.getPassword());
			user.setPhone(person.getPhone());
			user.setState(person.getState());
			user.setCode(person.getCode());
			userService.updatePerson(user);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return "msg";
		}
		return "personSet";
	}
	
	/*
	 * 个人设置:修改密码
	 */
	public String personSetPassword() {
		String pwd = ServletActionContext.getRequest().getParameter("oldpassword");
		try {
			User person = (User) ActionContext.getContext().getSession().get("person_user");
			if(pwd.equals(person.getPassword())) {
				user.setUid(person.getUid());
				user.setUsername(person.getUsername());
				user.setName(person.getName());
				user.setEmail(person.getEmail());
				user.setAddr(person.getAddr());
				user.setPhone(person.getPhone());
				user.setState(person.getState());
				user.setCode(person.getCode());
				userService.updatePerson(user);
				ActionContext.getContext().getSession().remove("session_user");
				return "loginUI";
			} else {
				this.addActionMessage("原密码输入错误！");
				return "msg";
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			ActionContext.getContext().getSession().remove("session_user");
			return "msg";
		}
	}
	
	/*
	 * 个人设置:修改手机
	 */
	public String personSetPhone() {
		try {
			User person = (User) ActionContext.getContext().getSession().get("person_user");
			user.setUid(person.getUid());
			user.setUsername(person.getUsername());
			user.setName(person.getName());
			user.setEmail(person.getEmail());
			user.setAddr(person.getAddr());
			user.setPassword(person.getPassword());
			user.setState(person.getState());
			user.setCode(person.getCode());
			userService.updatePerson(user);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return "msg";
		}
		return "personSet";
	}
	
}
