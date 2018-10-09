package net.zjitc.shop.utils;

import net.zjitc.shop.adminuser.domain.AdminUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/*
 * 拦截器的实现可以直接实现Interceptor借口，也可以继承MethodFilterInterceptor
 * MethodFilterInterceptor是一个拦截某一个具体的方法的方法过滤拦截器
 */
public class AdminInterceptor extends MethodFilterInterceptor {

	// 过滤器方法
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		/*
		 * 获取session中的管理员用户信息
		 * 		若存在，则放行
		 * 		若不存在，则拦截：保留错误提示，跳转到指定页面
		 */
		AdminUser admin = (AdminUser) ActionContext.getContext().getSession().get("adminuser");
		if(admin == null) { // 未登录
			// 错误信息保存
			ActionSupport actionSupport = (ActionSupport) arg0.getAction();
			actionSupport.addActionError("您还未登陆，无访问权限！");
			return "nologin";
		} else { // 登陆
			return arg0.invoke(); // 放行，可以去执行相应的Action
		}
	}

}
