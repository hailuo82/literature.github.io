package net.zjitc.shop.order.action;

import java.util.List;

import net.zjitc.shop.order.domain.Order;
import net.zjitc.shop.order.service.OrderService;
import net.zjitc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	// 模型（获取用户输入）
	private Order order = new Order();
	@Override
	public Order getModel() {
		return order;
	}
	
	// 注入业务层对象（OrderService）
	private OrderService orderService;
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	// 分页用到的数据：page（JSP页面传递的），limit 自定义
	private int page; // 当前页
	private int limit=20; // 一页的记录数
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	// 接受页面传递的状态值state
	private int state; // 订单状态
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	// 分页查询订单列表
	public String findAllOrder() {
		/*
		 * 1、调用业务层方法获得一页二级分类
		 * 2、结果保存在对象栈，以供JSP页面
		 */
		PageBean<Order> pageBean = orderService.findPageList(page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAllOrder";
	}
	
	// 查询所有订单列表
	/*public String findAllOrder() {
		 
		 * 1、调用业务层方法获得所有订单列表list
		 * 2、把订单列表保持在request，以供件商品循环显示
		 
		List<Order> list = orderService.findAllOrder();
		ActionContext.getContext().put("list", list);
		return "findAllOrder";
	}*/
	
	
	 // 按状态分页查询订单列表
	public String findByState() {
		/*
		 * 1、接收页面传递的状态值state 
		 * 2、调用业务层方法完成分页查询
		 * 3、将结果保存在对象栈
		 */
		int state = order.getState();
		PageBean<Order> pageBean = orderService.findByState(state, page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findByState";
	}
	
	// 修改订单状态
	public String editState() {
		/*
		 * 1、根据传入的oid得到Order对象（findById）
		 * 2、设置该对象的状态为3，即已发货
		 * 3、调用业务层方法完成更新
		 */
		order = orderService.findById(order.getOid());
		order.setState(3);
		orderService.edit(order);
		return "editState";
	}
}
