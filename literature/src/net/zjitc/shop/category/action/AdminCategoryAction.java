package net.zjitc.shop.category.action;

import java.util.List;

import net.zjitc.shop.category.domain.Category;
import net.zjitc.shop.category.service.CategoryService;
import net.zjitc.shop.utils.CategoryException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
	// 模型（获取用户输入）
	private Category category = new Category();
	@Override
	public Category getModel() {
		return category;
	}
	
	// setter注入
	private CategoryService categoryService;
	
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	/*
	 * 查询所有一级分类
	 */
	public String findAllCategory() {
		List<Category> clist = categoryService.findAllCategory();
		ActionContext.getContext().put("cList", clist);
		return "findAllCategory";
	}
	
	/*
	 * 删除：删除某个一级分类：根据传入的cid删除
	 */
	public String delete() {
		/*
		 * 1、根据传入的cid，获得要删除的一级分类Category对象
		 * 2、调用业务层方法进行删除
		 */
		category = categoryService.findById(category.getCid());
		try { // 正常删除，重定向到列表
			categoryService.delete(category);
			return "tolist";
		} catch (CategoryException e) { // Service层抛出异常
			this.addActionError(e.getMessage());
			return "error";
		}
	}
	
	/*
	 * 添加页面
	 */
	public String add() {
		return "add";
	}
	
	/*
	 * 添加：添加一级分类
	 */
	public String saveCategory() {
		/*
		 * 
		 */
		categoryService.add(category);
		return "tolist";
	}
	
	/*
	 * 修改页面：
	 * “列表”传递cid，修改页面需要显示原来的分类名称
	 */
	public String edit() {
		/*
		 * 1、调用业务层方法：根据传入cid参数的获取Category对象，更新模型category，用于页面回显
		 */
		int cid = category.getCid();
		category = categoryService.findById(cid);
		return "edit";
	}
	
	/*
	 * 修改：修改一级分类名称
	 */
	public String update() {
		/*
		 * 1、用户输入信息自动封装在模型category中
		 * 2、调用业务层方法完成修改操作
		 */
		categoryService.edit(category);
		return "tolist";
	}
}
