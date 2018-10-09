package net.zjitc.shop.evaluate.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.zjitc.shop.evaluate.domain.Evaluate;

public class EvaluateDao extends HibernateDaoSupport {

	// 保存评价
	public void saveEval(Evaluate evaluate) {
		this.getHibernateTemplate().save(evaluate);	
	}
}
