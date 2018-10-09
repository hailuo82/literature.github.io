package net.zjitc.shop.utils;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class PageHibernateCallback<T> implements HibernateCallback {
	private String hql;
	private Object[] params;
	private int beginCount;
	private int limit;
	
	/**
	 * 构造方法：因为要实现分页查询需要得到以下这4个信息。
	 * @param hql     查询的hql语句
	 * @param params  参数数组
	 * @param beginCount  开始的记录数
	 * @param limit  1页显示的记录数
	 */
	public PageHibernateCallback(String hql, Object[] params, int beginCount, int limit) {
		super();
		this.hql = hql;
		this.params = params;
		this.beginCount = beginCount;
		this.limit = limit;
	}

	@Override
	public Object doInHibernate(Session arg0) throws HibernateException,
			SQLException {
		/*
		 * 1、执行hql语句
		 * 2、给hql语句加上实际参数
		 * 3、执行分页查询
		 * 4、返回结果
		 */
		Query query = arg0.createQuery(hql); // 执行hql语句
		// 给hql语句加上实际参数
		if(params != null) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		// 执行分页查询
		query.setFirstResult(beginCount);
		query.setMaxResults(limit);
		
		// 返回结果
		return query.list();
	}
	
}
