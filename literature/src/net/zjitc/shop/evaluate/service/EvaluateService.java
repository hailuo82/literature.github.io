package net.zjitc.shop.evaluate.service;

import net.zjitc.shop.evaluate.dao.EvaluateDao;
import net.zjitc.shop.evaluate.domain.Evaluate;

public class EvaluateService {
	// 注入Dao
	private EvaluateDao evaluateDao;
	public EvaluateDao getEvaluateDao() {
		return evaluateDao;
	}
	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}
	// 保存评价内容
	public void saveEval(Evaluate evaluate) {
		evaluateDao.saveEval(evaluate);		
	}

}
