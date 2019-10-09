package com.cn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.T_Good;
import com.cn.vo.Tping;

public class GoodsDetailService {
	//商品详细信息获取
	public T_Good getGoods(int goodId) {
		T_Good tgood=(T_Good)MyDB.Query("select * from t_goods where goods_id=?", T_Good.class,goodId);
		
		return tgood;
	}
	
	//商品评价信息获取
	public List<Tping> getGoodsPinjia(int goodId) {

		List<Map<String, Object>> list=MyDB.executeQuery("select * from t_ping where goods_id=?",goodId);
		List<Tping> tping=getTping(list);
		return tping;
	}
	private List<Tping> getTping(List<Map<String, Object>> map){
		List<Tping> list_tping=new ArrayList<Tping>();
		for(Map<String, Object> map1:map) {
			Tping tp=new Tping();
			tp.setId((Integer)map1.get("id"));
			tp.setOrder_id(map1.get("order_id").toString());
			tp.setOrderitem_id(map1.get("orderitem_id").toString());
			tp.setGoods_id(map1.get("goods_id").toString());
			tp.setMingcheng(map1.get("mingcheng").toString());
			tp.setUser_id(map1.get("user_id").toString());
			tp.setInfo(map1.get("info").toString());
			tp.setLoginname(map1.get("loginname").toString());
			tp.setAdddate(map1.get("adddate").toString());
			list_tping.add(tp);
		}
		return list_tping;
	}
	
	
}
