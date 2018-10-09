package net.zjitc.shop.collect.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.zjitc.shop.collect.domain.Collect;

public class CollectDao extends HibernateDaoSupport {
	// 根据uid查询收藏
	public List<Collect> findByUid(int uid) {
		String hql = "from Collect where uid=? order by collecttime desc";
		return this.getHibernateTemplate().find(hql, uid);
	}

	// 根据uid查询收藏数
	public int findCountByUid(int uid) {
		String hql = "select count(*) from Collect where uid=?";
		Long c = (Long) this.getHibernateTemplate().find(hql, uid).listIterator().next();
		int count = c.intValue();
		return count;
	}

	// 添加到收藏
	public void add(Collect collect) {
		this.getHibernateTemplate().save(collect);
	}

	// 根据ucid查询所有收藏
	public Collect findAllCollection(int ucid) {
		return (Collect) this.getHibernateTemplate().get(Collect.class, ucid);
	}

	// 删除收藏
	public void delete(Collect collect) {
		this.getHibernateTemplate().delete(collect);
	}

}
