package net.zjitc.shop.product.action;

import java.util.List;

import net.zjitc.shop.category.domain.Category;
import net.zjitc.shop.categorysecond.domain.CategorySecond;
import net.zjitc.shop.categorysecond.service.CategorySecondService;
import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.product.service.ProductService;
import net.zjitc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	// 模型驱动
	Product product = new Product();

	@Override
	public Product getModel() {
		return product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	// 注入ProductService
	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 注入CategorySecondService
	private CategorySecondService categorySecondService;

	public CategorySecondService getCategorySecondService() {
		return categorySecondService;
	}
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// 接收页面传递的cid\csid\page，以及定义limit
	private int cid, csid, page, limit = 12;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCsid() {
		return csid;
	}

	public void setCsid(int csid) {
		this.csid = csid;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// 根据一级分类id查找分页商品
	public String findByCid() {
		/*
		 * 1、调用业务层方法得到分页商品数据 2、将结果保存在对象栈
		 */
		PageBean<Product> pageBean = productService.findByCid(cid, page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		// 根据页面传递的一级分类id查询一级分类名称
		PageBean<CategorySecond> clist = categorySecondService.findCList(cid); 
		ActionContext.getContext().getSession().put("clist", clist);
		
		// 根据一级分类id查询二级分类
		PageBean<CategorySecond> cslist = categorySecondService.findCSList(cid); 
		ActionContext.getContext().getSession().put("cslist", cslist);
		
		// 利用分页查询前第10~12条热门商品
		PageBean<Product> hotrightlist = productService.findHotRightProduct(); 
		ActionContext.getContext().put("hotrightlist", hotrightlist);
		return "findByCid";
	}

	// 根据二级分类id查找分页商品
	public String findByCsid() {
		/*
		 * 1、调用业务层方法得到分页商品数据 2、将结果保存在对象栈
		 */
		PageBean<Product> pageBean = productService.findByCsid(csid, page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		// 利用分页查询前第10~12条热门商品
		PageBean<Product> hotrightlist = productService.findHotRightProduct(); 
		ActionContext.getContext().put("hotrightlist", hotrightlist);
		return "findByCsid";
	}

	// 根据商品id查找商品详情
	public String findByPid() {
		/*
		 * 1、调用业务层方法得到商品详情信息 2、将结果保存在model
		 */
		product = productService.findByPid(product.getPid());
		
		// 利用分页查询前第10~12条热门商品
		PageBean<Product> hotrightlist = productService.findHotRightProduct(); 
		ActionContext.getContext().put("hotrightlist", hotrightlist);
		
		return "findByPid";
	}

	// 根据商品名称查找商品详情
	public String findByName() {
		/*
		 * 1、调用业务层方法得到商品详情信息 
		 * 2、将结果保存在model
		 */

		List<Product> list = productService.findAllProduct();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPname().contains(product.getPname())) {
				product = productService.findByName(product.getPname());
				return "findByName";
			}
		}
		
		cid = 1;
		PageBean<Product> pageBean = productService.findByCid(cid, page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		// 根据页面传递的一级分类id查询一级分类名称
		PageBean<CategorySecond> clist = categorySecondService.findCList(cid); 
		ActionContext.getContext().getSession().put("clist", clist);
		
		// 根据一级分类id查询二级分类
		PageBean<CategorySecond> cslist = categorySecondService.findCSList(cid); 
		ActionContext.getContext().getSession().put("cslist", cslist);
		return "findByCid";
	}
	
}
