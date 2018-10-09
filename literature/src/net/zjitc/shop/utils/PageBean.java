package net.zjitc.shop.utils;

import java.util.List;

// 分页数据 Bean/实体类
public class PageBean<T> {
	// 页面传递的数据：
	private int page; // 当前页
	private int limit; // 一页显示多少条
	
	// 数据库获取的数据：
	private int totalCount; // 总数据
	private List<T> list; // 一页的数据
	
	// 计算得到的数据：
	private int pageCount; // 总页数
	private int beginIndex; // 开始页码
	private int endIndex; // 结束页码
	/////////////////////////////////////////////
	
	public PageBean() {
		super();
	}
	
	/**
	 * 构造方法：接收必要的4个属性，计算出其他3个属性
	 * @param page  当前页
	 * @param limit 1页显示多少条记录
	 * @param totalCount 总数据数
	 * @param list  1页数据
	 */
	public PageBean(int page, int limit, int totalCount, List<T> list) {
		super();
		this.page = page;
		this.limit = limit;
		this.totalCount = totalCount;
		this.list = list;
		
		/* 
		 * 1、计算总页数。
		 *   假设总记录数100，每页显示10条，则总页数是10
		 *   假设总记录数99，每页显示10条，则总页数是9+1
		 *   假设总记录数101，每页显示10条，则总页数是10+1
		 */
		int n = totalCount/limit; // 商：总记录数除以每页的记录数
		// 判断余数（取模）：余数=0，总页数=商
		//             余数>0，总页数=商+1
		if(totalCount%limit != 0) {
			this.pageCount = n+1;
		} else {
			this.pageCount = n;
		}
		
		/*// 三元：计算得到的总页数
		this.pageCount = totalCount%limit == 0?n:n+1;*/
		
		
		/*
		 * 2、计算起始页码和结束页码
		 *   若总页数小于等于10页，则全部显示
		 *   否则，显示当前页附近的10页（前4页+当前页+后5页）
		 *      若头溢出，即当前页的前面不足4页：起始页码为1，结束页码为10
		 *      若尾溢出，即当前页的后面不足5页：结束页面为最大页码，起始页码为最大页码-9
		 *  
		 *  例子：总共13页，当前页尾6时，bengin=6-4=2，end=6+5=11
		 *      当前页为3，begin=1，end=10
		 *      当前页为9，end=13,begin=13-9=4
		 */
		if(pageCount <= 10) { 	// 若总页数小于等于10页
			this.beginIndex = 1;
			this.endIndex = pageCount;
		} else { 				// 若总页数大于10页
			beginIndex = page - 4;
			endIndex = page + 5;
			if(beginIndex <= 1) { // 当前页的前面四页不足4页
				beginIndex = 1;
				endIndex = 10;
			}
			if(endIndex > pageCount) { // 当前页的后面不足5页
				endIndex = pageCount;
				beginIndex = pageCount - 9;
			}
		}
	}

	/////////////////////////////////////////////
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
}
