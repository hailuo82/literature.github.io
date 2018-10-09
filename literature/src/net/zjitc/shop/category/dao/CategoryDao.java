package net.zjitc.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.zjitc.shop.category.domain.Category;

public class CategoryDao extends HibernateDaoSupport {

	// 查询
	public List<Category> findAllCategory() {
		String hql = " from Category";
		return this.getHibernateTemplate().find(hql);
	}

	// 添加
	public void add(Category category) {
		this.getHibernateTemplate().save(category);
	}

	// 根据cid查询对象，用于回显
	public Category findById(int cid) {
		Category category = (Category) this.getHibernateTemplate().get(Category.class, cid);
		return category;
	}
	// 修改
	public void edit(Category category) {
		this.getHibernateTemplate().update(category);
	}

	// 删除
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

}
