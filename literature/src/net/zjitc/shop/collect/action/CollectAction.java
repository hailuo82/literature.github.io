package net.zjitc.shop.collect.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.zjitc.shop.collect.domain.Collect;
import net.zjitc.shop.collect.service.CollectService;
import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.product.service.ProductService;
import net.zjitc.shop.user.domain.User;
import net.zjitc.shop.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CollectAction extends ActionSupport implements ModelDriven<Collect> {
	// 模型（获取用户输入）
	private Collect collect = new Collect();
	@Override
	public Collect getModel() {
		return collect;
	}
	
	// 注入Service
	private CollectService collectService;
	private UserService userService;
	private ProductService productService;
	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 获取页面传递的uid，pid
	private int uid,pid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	// 根据uid查询书籍
	public String findByUid() {
		// 根据uid查询收藏
		List<Collect> collectlist = collectService.findByUid(uid);
		ActionContext.getContext().getSession().put("collectlist", collectlist);
		
		// 根据uid查询收藏数
		int count = collectService.findCountByUid(uid);
		ActionContext.getContext().getSession().put("collectcount", count);
		return "collection";
	}
	
	// 添加收藏
	public String add() {
		// 将获取到的用户存到模型中
		List<User> user = userService.findUserById(uid);
		User my = user.get(0);
		collect.setUser(my);
		
		// 获取商品信息
		List<Product> product = productService.findProductByPid(pid);

		List<Collect> collectlist = collectService.findByUid(uid);
		ActionContext.getContext().getSession().put("collectlist", collectlist);
		int count = collectService.findCountByUid(uid);
		ActionContext.getContext().getSession().put("collectcount", count);
		
		for(int i=0; i<collectlist.size(); i++) {
			if(collectlist.get(i).getPname().equals(product.get(0).getPname())) {
				this.addActionMessage("该书已添加了，不能重复添加！");
				return "msg";
			}
		}
		collect.setPname(product.get(0).getPname());
		
		DateFormat df = DateFormat.getDateTimeInstance();
		collect.setCollecttime(df.format(new Date())); // 补全时间
		// 添加到收藏
		collectService.add(collect);
		return "collection";
	}
	
	// 删除收藏
	public String delete(){
		try {
			collect = collectService.findAllCollection(collect.getUcid());
			collectService.delete(collect);
			this.addActionMessage("删除成功！");
			//ServletActionContext.getRequest().setAttribute("msg", "删除成功");
		} catch (Exception e) {
			this.addActionError("删除失败，错误原因:"+e.getMessage());
			//ServletActionContext.getRequest().setAttribute("msg", "删除失败");
			//return "msg";
		}
		return "msg";
	}
}
