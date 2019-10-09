package com.cn.vo;


public class TOrderitem {
	private Integer orderItem_id;
	private Integer order_id;
	private Integer goods_id;
	private Integer goods_quantity;
	private T_Good goods;
	
	public TOrderitem() {
	}
	public Integer getOrderItem_id() {
		return orderItem_id;
	}
	public void setOrderItem_id(Integer orderItem_id) {
		this.orderItem_id = orderItem_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getGoods_quantity() {
		return goods_quantity;
	}
	public void setGoods_quantity(Integer goods_quantity) {
		this.goods_quantity = goods_quantity;
	}
	public T_Good getGoods() {
		return goods;
	}
	public void setGoods(T_Good goods) {
		this.goods = goods;
	}

	
	
}
