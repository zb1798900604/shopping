package com.cn.service;

import com.cn.util.MyDB;
import com.cn.vo.TOrderitem;
import com.cn.vo.T_Good;

public class AddCartService {
	public TOrderitem getCart(int goodsId,int quantity) {
		T_Good goods=(T_Good)MyDB.Query("select * from t_goods where goods_id=?", T_Good.class, goodsId);
		
		TOrderitem tOrderitem=new TOrderitem();
		tOrderitem.setGoods(goods);
		tOrderitem.setGoods_quantity(quantity);
		return tOrderitem;
	}
	
	
}
