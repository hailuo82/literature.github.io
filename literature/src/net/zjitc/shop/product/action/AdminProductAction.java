package net.zjitc.shop.product.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import net.zjitc.shop.categorysecond.domain.CategorySecond;
import net.zjitc.shop.categorysecond.service.CategorySecondService;
import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.product.service.ProductService;
import net.zjitc.shop.utils.PageBean;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	// 模型（获取用户输入）
	private Product product = new Product();
	@Override
	public Product getModel() {
		return product;
	}
	
	// 注入业务层（ProductService）
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
	
	// Struts2上传文件用到的3个属性，setter、getter方法
	private File upload; // 上传的文件，名字保持一致
	private String uploadFileName; // 上传文件名，注意命名
	private String uploadContextType; // 得到上传文件的类型，命名规则：文件名+ContextType
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContextType() {
		return uploadContextType;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	
	// 分页用到的数据：page（JSP页面传递的），limit 自定义
	private int page; // 当前页
	private int limit=10; // 一页的记录数
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	/*
	 * 分页列表：只查询一页数据
	 */
	public String findAllProduct() {
		/*
		 * 1、调用业务层方法获得一页商品数据
		 * 2、结果保存在对象栈，以供JSP页面
		 */
		PageBean<Product> pageBean = productService.list(page, limit);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAllProduct";
	}
	
	/*
	 * 查询所有商品列表
	 
	public String findAllProduct() {
		
		 * 1、调用业务层方法获取所有商品列表
		 * 2、将列表保存在request域，返回
		 
		List<Product> list = productService.findAllProduct();
		ActionContext.getContext().put("list", list);
		return "findAllProduct";
	}*/
	
	/*
	 * 添加页面
	 */
	public String addUI() {
		/*
		 * 1、得到所有二级分类列表（通过业务层方法）
		 * 2、将二级分类列表保存到request域
		 * 3、打开添加页面通过（返回值）
		 */
		List<CategorySecond> csList = categorySecondService.list();
		ActionContext.getContext().put("csList", csList);
		return "addUI";
	}
	
	/*
	 * 添加
	 */
	public String add() throws Exception {
		/*
		 * 1、获得页面输入的信息（通过实现modelDriven过滤器，自动将页面信息保存在model）
		 * 2、该model还缺“pdate”时间字段，补全
		 * 3、该model还缺“image”照片字段，需要特殊处理
		 * 4、调用业务层方法完成添加
		 */
		product.setPdate(new Date()); // 补全model里的时间
		
		/*
		 * 3、将上传的文件保持在/products/4目录下
		 * 	3.1 得到文件上传的磁盘绝对路径
		 * 	3.2 得到目标文件
		 * 	3.3 将上传的文件拷贝到目标文件
		 */
		String path = ServletActionContext.getServletContext().getRealPath("/books/1") 
				+ "\\" + uploadFileName; // 获取上传文件的绝对路径
		File destFile = new File(path); // 目标文件
		FileUtils.copyFile(upload, destFile);
		
		product.setImage("books/1/" + uploadFileName); // 补全model里的照片
		
		// 调用业务层方法完成添加操作
		productService.add(product);
		return "tolist";
	}
	
	/*
	 * 修改页面
	 */
	public String editUI() {
		/*
		 * 1、根据传入的pid获得商品对象，保存在model，这样jsp可以用于回显
		 * 2、获得所有二级分类列表保存在request域，用于回显和选择
		 */
		product = productService.findById(product.getPid());
		List<CategorySecond> csList = categorySecondService.list();
		ActionContext.getContext().put("csList", csList);
		int pid = product.getPid();
		product = productService.findById(pid);
		return "editUI";
	}
	
	/*
	 * 修改功能
	 */
	public String edit() throws Exception {
		/*
		 * 1、页面修改的内容自动会封装在model
		 * 2、考虑页面上图片的回显
		 * 		考虑图片是否修改，参照上传图片，同样需要设置model的image属性
		 * 		问题：若图片不修改，则upload会是空
		 * 3、调用业务层方法完成修改操作
		 */
		if(upload != null) {
			product.setPdate(new Date()); // 补全model里的时间
			String path = ServletActionContext.getServletContext().getRealPath("/products/4") 
					+ "\\" + uploadFileName; // 获取上传文件的绝对路径
			File destFile = new File(path); // 目标文件
			FileUtils.copyFile(upload, destFile);
			
			product.setImage("products/4/" + uploadFileName); // 补全model里的照片
		}
		
		productService.edit(product);
		return "tolist";
	}
	
	/*
	 * 删除
	 */
	public String delete() {
		productService.delete(product);
		return "tolist";
	}
}
