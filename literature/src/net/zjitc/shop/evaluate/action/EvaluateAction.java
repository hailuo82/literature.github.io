package net.zjitc.shop.evaluate.action;

import java.util.Date;

import net.zjitc.shop.evaluate.domain.Evaluate;
import net.zjitc.shop.evaluate.service.EvaluateService;
import net.zjitc.shop.order.domain.OrderItem;
import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.product.service.ProductService;
import net.zjitc.shop.user.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EvaluateAction extends ActionSupport implements ModelDriven<Evaluate> {
	// 模型驱动
	private Evaluate evaluate = new Evaluate();
	@Override
	public Evaluate getModel() {
		return evaluate;
	}
	
	// 注入Service
	private EvaluateService evaluateService;
	private ProductService productService;
	public EvaluateService getEvaluateService() {
		return evaluateService;
	}
	public void setEvaluateService(EvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	// 接收页面传递的pid
	private int pid;

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	// 去评价，根据商品id查询商品信息
	public String findByPid(){
		/*
		 * 1、调用业务层方法，根据传入的pid查询商品信息
		 * 2、将结果保存(若是保存在request，jsp取得时候用#)
		 */
		Product product=productService.findByPid(pid);
		ActionContext.getContext().put("product", product);
		return "findByPid";
	}
	
	// 立即评价：保存评价信息，更新订单项的状态
	public String saveEval(){
		/*
		 * 1、评价页面用户输入的信息，自动封装到model，补全model中的其他属性：评价的用户和评价时间
		 * 2、调用业务层方法完成保存订单
		 * 3、根据传入的订单项id，调用业务层方法得到订单项对象
		 * 4、设置该订单项的状态为3，表示已完成评价，完成交易
		 * 5、调用业务层方法完成订单项的更新
		 * 6、保存提示信息，返回
		 */
		User user=(User) ActionContext.getContext().getSession().get("session_user");
		evaluate.setUser(user); //设置评价的用户
		evaluate.setDate(new Date()); //保存时间
		
		evaluateService.saveEval(evaluate);
		
		ActionContext.getContext().put("msg", "评价成功");
		return "saveEval";
	}
}
