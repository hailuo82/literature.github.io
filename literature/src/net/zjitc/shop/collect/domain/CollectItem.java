package net.zjitc.shop.collect.domain;

import net.zjitc.shop.product.domain.Product;

public class CollectItem {
	private int uciid;
	
	// 关联商品，与商品的多对一关系
	private Product product;
	
	// 关联收藏，与收藏的多对一关系
	private Collect collect;

	public int getUciid() {
		return uciid;
	}

	public void setUciid(int uciid) {
		this.uciid = uciid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}

}
