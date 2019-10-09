package com.cn.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.cn.vo.TOrderitem;
import com.cn.vo.T_Good;

public class Cart {
	private Map<Integer,TOrderitem> items;
	public Cart() {
		if(items==null) {
			items =new HashMap<Integer,TOrderitem>();
		}
	}

	//添加商品
	public void addCart(Integer goodsId,TOrderitem orderItem) {
		if(items.containsKey(goodsId)) {
			TOrderitem orderitems= items.get(goodsId);
			orderitems.setGoods_quantity(orderitems.getGoods_quantity()+orderItem.getGoods_quantity());
			items.put(goodsId, orderitems);
		}else {
			items.put(goodsId, orderItem);
		}
	}

	public  int getTotalPrice() {
		int totalprice=0;
		for(Iterator it=items.values().iterator();it.hasNext();) {
			TOrderitem tOrderitem=(TOrderitem)it.next();
			T_Good goods=tOrderitem.getGoods();
			Integer goods_quantity=tOrderitem.getGoods_quantity();
			totalprice+=goods.getGoods_shichangjia()*goods_quantity;
		}
		return totalprice;
	}
	public Map<Integer, TOrderitem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, TOrderitem> items) {
		this.items = items;
	}

	//修改
	public void updateCart(int goodsId,int quantity) {
		TOrderitem tOrderitem=items.get(goodsId);
		tOrderitem.setGoods_quantity(quantity);
		items.put(goodsId, tOrderitem);
	}
	//删除
	public void delCart(int goodsId) {
		items.remove(goodsId);
	}
	public void clearCart(){
		items.clear();
	}

}
