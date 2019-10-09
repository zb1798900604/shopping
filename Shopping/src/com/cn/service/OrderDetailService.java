package com.cn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.TOrderitem;
import com.cn.vo.T_Good;

public class OrderDetailService {
	public List<TOrderitem> getOrder(String orderId) {
		List<Map<String, Object>> lists=MyDB.executeQuery("select * from t_orderitem where order_id=?", orderId);
		List<TOrderitem> list = getALL(lists);
		for (int i =0; i<list.size();i++) {
			TOrderitem tOrderitem = list.get(i);
			tOrderitem.setGoods((T_Good)MyDB.Query("select *  from t_goods where goods_id =?", T_Good.class,tOrderitem.getGoods_id()));
		}
		return list;
		
	}
	
	
	private List<TOrderitem> getALL(List<Map<String, Object>> map){
		List<TOrderitem> list=new ArrayList<TOrderitem>();
		for(Map<String ,Object> map1:map) {
			TOrderitem to=new TOrderitem();
			to.setOrderItem_id((Integer)map1.get("orderItem_id"));
			to.setOrder_id((Integer)map1.get("order_id"));
			to.setGoods_id((Integer)map1.get("goods_id"));
			to.setGoods_quantity((Integer)map1.get("goods_quantity"));
			
			list.add(to);
		}
		return list;
	}

}
