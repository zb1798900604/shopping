package com.cn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.TOrder;
import com.cn.vo.Tuser;

public class MyOrderService {
	public List<TOrder> getMyOrder(Tuser user){
		List<Map<String, Object>> listorder=MyDB.executeQuery("select * from t_order where order_user_id=?",user.getUser_id());
		List<TOrder> order=goodOrder(listorder);
		return order;
		
	}
	private List<TOrder> goodOrder(List<Map<String, Object>> map){
		List<TOrder> list_order=new ArrayList<TOrder>();
		for (Map<String, Object> map1 : map) {
			TOrder to=new TOrder();
			to.setOrder_id((Integer)map1.get("order_id"));
			to.setOrder_bianhao(map1.get("order_bianhao").toString());
			to.setOrder_date(map1.get("order_date").toString());
			to.setOrder_zhuangtai(map1.get("order_zhuangtai").toString());
			to.setOrder_jine((Integer)map1.get("order_jine"));
			to.setOrder_songhuodizhi(map1.get("order_songhuodizhi").toString());
			to.setOrder_fukuangfangshi(map1.get("order_fukuangfangshi")==null?null:map1.get("order_fukuangfangshi").toString());
			to.setOrder_user_id((Integer)map1.get("order_user_id"));
			list_order.add(to);
		}
		return list_order;
	}


}
