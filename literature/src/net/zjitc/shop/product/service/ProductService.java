package net.zjitc.shop.product.service;

import java.util.List;

import net.zjitc.shop.product.dao.ProductDao;
import net.zjitc.shop.product.domain.Product;
import net.zjitc.shop.utils.PageBean;

public class ProductService {
	// 注入Dao
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/*
	 * 查询所有商品列表
	 */
	public List<Product> findAllProduct() {
		return productDao.findAllProduct();
	}
	
	/*
	 * 查询分页列表：只查询一页
	 */
	public PageBean<Product> list(int page, int limit) {
		return productDao.list(page, limit);
	}
	
	/*
	 * 添加商品
	 */
	public void add(Product product) {
		productDao.add(product);
	}
	
	/*
	 *  根据pid查询对象，用于回显
	 */
	public Product findById(int pid) {
		return productDao.findById(pid);
	}
	
	/*
	 * 修改
	 */
	public void edit(Product product) {
		productDao.edit(product);
	}
	
	/*
	 * 删除
	 */
	public void delete(Product product) {
		productDao.delete(product);
	}
	
	/*
	 * 利用分页查询第1条热门商品
	 */
	public PageBean<Product> findHotProduct() {
		return productDao.findHotProduct();
	}
	
	/*
	 * 利用分页查询第2~4条热门商品
	 */
	public PageBean<Product> findSecondHotProduct() {
		return productDao.findSecondHotProduct();
	}
	
	/*
	 * 利用分页查询第10~12条热门商品
	 */
	public PageBean<Product> findHotRightProduct() {
		return productDao.findHotRightProduct();
	}
	
	/*
	 * 利用分页查询第1条最新商品
	 */
	public PageBean<Product> findNewProduct() {
		return productDao.findNewProduct();
	}
	
	/*
	 * 利用分页查询第2~4条最新商品
	 */
	public PageBean<Product> findSecondNewProduct() {
		return productDao.findSecondNewProduct();
	}
	
	/*
	 * 利用分页查询第10~12条最新商品
	 */
	public PageBean<Product> findNewRightProduct() {
		return productDao.findNewRightProduct();
	}

	// 根据一级分类id查找分页商品
	public PageBean<Product> findByCid(int cid, int page, int limit) {		
		return productDao.findByCid(cid,page,limit);
	}

	// 根据二级分类id查找分页商品
	public PageBean<Product> findByCsid(int csid, int page, int limit) {
		return productDao.findByCsid(csid,page,limit);
	}

	// 根据商品id查看商品详情
	public Product findByPid(Integer pid) {		
		return productDao.findByPid(pid);
	}
	
	// 根据商品名称查看商品详情
	public Product findByName(String pname) {
		return productDao.findByName(pname);
	}

	/*
	 * 男频排行榜
	 */
	public PageBean<Product> findManProduct() {
		return productDao.findManProduct();
	}
	
	/*
	 * 女频排行榜
	 */
	public PageBean<Product> findWomanProduct() {
		return productDao.findWomanProduct();
	}
	
	/*
	 * 根据pid查询商品信息
	 */
	public List<Product> findProductByPid(int pid) {
		return productDao.findProductByPid(pid);
	}

}
