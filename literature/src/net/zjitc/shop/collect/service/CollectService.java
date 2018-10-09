package net.zjitc.shop.collect.service;

import java.util.List;

import net.zjitc.shop.collect.dao.CollectDao;
import net.zjitc.shop.collect.domain.Collect;

public class CollectService {
	//注入Dao
	private CollectDao collectDao;
	
	public CollectDao getCollectDao() {
		return collectDao;
	}
	public void setCollectDao(CollectDao collectDao) {
		this.collectDao = collectDao;
	}

	// 根据uid查询收藏
	public List<Collect> findByUid(int uid) {
		return collectDao.findByUid(uid);
	}
	
	// 根据uid查询收藏数
	public int findCountByUid(int uid) {
		return collectDao.findCountByUid(uid);
	}
	
	// 添加到收藏
	public void add(Collect collect) {
		collectDao.add(collect);
	}
	
	// 根据ucid查询所有收藏
	public Collect findAllCollection(int ucid) {
		return collectDao.findAllCollection(ucid);
	}
	
	// 删除收藏
	public void delete(Collect collect) {
		collectDao.delete(collect);
	}

}
