package net.zjitc.shop.index;

import java.util.List;

import net.zjitc.shop.category.domain.Category;
import net.zjitc.shop.category.service.CategoryService;
import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.product.service.ProductService;
import net.zjitc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	// 注入service
	private CategoryService categoryService;
	private ProductService productService;

	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public String execute() throws Exception {
		/*
		 * 1、得到所有一级分类列表（调用业务层方法）
		 * 2、保存结果
		 * 3、得到热门商品列表（调用业务层方法）
		 * 4、保存结果
		 * 5、得到最新商品列表（调用业务层方法）
		 * 6、保存结果
		 */
		List<Category> list = categoryService.findAllCategory();
		ActionContext.getContext().getSession().put("cList", list);
		
		/*
		 * 利用分页查询第1条热门商品
		 */		
		PageBean<Product> hotlist = productService.findHotProduct(); 
		ActionContext.getContext().put("hotlist", hotlist);
		
		/*
		 * 利用分页查询前第2~4条热门商品
		 */
		PageBean<Product> secondhotlist = productService.findSecondHotProduct(); 
		ActionContext.getContext().put("secondhotlist", secondhotlist);
		
		/*
		 * 利用分页查询前第10~12条热门商品
		 */
		PageBean<Product> hotrightlist = productService.findHotRightProduct(); 
		ActionContext.getContext().put("hotrightlist", hotrightlist);
		
		/*
		 * 利用分页查询第1条最新商品
		 */		
		PageBean<Product> nlist = productService.findNewProduct(); 
		ActionContext.getContext().put("nList", nlist);
		
		/*
		 * 利用分页查询第2~4条最新商品
		 */
		PageBean<Product> nsecondlist = productService.findSecondNewProduct(); 
		ActionContext.getContext().put("nsecondlist", nsecondlist);
		
		/*
		 * 利用分页查询第10~12条最新商品
		 */
		PageBean<Product> nrightlist = productService.findNewRightProduct(); 
		ActionContext.getContext().put("nrightlist", nrightlist);
		
		/*
		 * 男频排行榜
		 */
		PageBean<Product> manlist = productService.findManProduct();
		ActionContext.getContext().put("manlist", manlist);
		
		/*
		 * 女频排行榜
		 */
		PageBean<Product> womanlist = productService.findWomanProduct();
		ActionContext.getContext().put("womanlist", womanlist);
		
		return "index";
	}
}
