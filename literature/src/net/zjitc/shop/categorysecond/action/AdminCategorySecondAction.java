package net.zjitc.shop.categorysecond.action;

import java.util.List;

import net.zjitc.shop.category.domain.Category;
import net.zjitc.shop.category.service.CategoryService;
import net.zjitc.shop.categorysecond.domain.CategorySecond;
import net.zjitc.shop.categorysecond.service.CategorySecondService;
import net.zjitc.shop.utils.CategoryException;
import net.zjitc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {
	// 模型（获取用户输入）
	private CategorySecond categorySecond = new CategorySecond();
	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}
	// 注入业务层对象
	private CategorySecondService categorySecondService;
	public CategorySecondService getCategorySecondService() {
		return categorySecondService;
	}
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	// 注入CategoryService
	private CategoryService categoryService;
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
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
	
	/*
	 * 分页列表：只查询一页数据
	 */
	public String list() {
		/*
		 * 1、调用业务层方法获得一页二级分类
		 * 2、结果保存在对象栈，以供JSP页面
		 */
		PageBean<CategorySecond> pageBean = categorySecondService.findPageList(page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	
	/*
	 * 查询所有二级分类列表
	 
	public String list() {
		
		 * 1、调用业务层方法获得所有二级分类列表list
		 * 2、把二级分类列表保持在request，以供件商品循环显示
		 
		List<CategorySecond> list = categorySecondService.list();
		ActionContext.getContext().put("list", list);
		return "list";
	}*/
	
	/*
	 * 添加页面
	 */
	public String addUI() {
		/*
		 * 1、得到所有一级分类列表（通过业务层方法）
		 * 2、将一级分类列表保存到request域
		 * 3、打开添加页面通过（返回值）
		 */
		List<Category> clist = categoryService.findAllCategory();
		ActionContext.getContext().put("cList", clist);
		return "addUI";
	}
	
	/*
	 * 添加
	 */
	public String add() {
		categorySecondService.add(categorySecond);
		return "tolist";
	}
	
	/*
	 * 修改页面
	 */
	public String editUI() {
		List<Category> clist = categoryService.findAllCategory();
		ActionContext.getContext().put("cList", clist);
		int csid = categorySecond.getCsid();
		categorySecond = categorySecondService.findById(csid);
		return "editUI";
	}
	
	/*
	 * 修改
	 */
	public String edit() {
		categorySecondService.edit(categorySecond);
		return "tolist";
	}
	
	/*
	 * 删除
	 */
	public String delete() {
		/*
		 * 1、根据传入的csid，获得要删除的二级分类CategorySecond对象
		 * 2、调用业务层方法进行删除
		 */
		categorySecond = categorySecondService.findById(categorySecond.getCsid());
		try { // 正常删除，重定向到列表
			categorySecondService.delete(categorySecond);
			return "tolist";
		} catch (CategoryException e) { // Service层抛出异常
			this.addActionError(e.getMessage());
			return "error";
		}
	}
}
