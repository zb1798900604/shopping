package com.cn.service;

import com.cn.util.MyDB;
import com.cn.vo.TOrder;
import com.cn.vo.TOrderitem;
import com.cn.vo.T_Good;

public class OrderService {
	public TOrder query(TOrder order) {
		MyDB.executeUpdate("insert into t_order (order_bianhao,order_date,order_zhuangtai,order_jine,order_songhuodizhi,order_fukuangfangshi,order_user_id) value"
				+ "(?,?,?,?,?,?,?)", 
				order.getOrder_bianhao(),order.getOrder_date(),order.getOrder_zhuangtai(),order.getOrder_jine(),order.getOrder_songhuodizhi(),
				order.getOrder_fukuangfangshi(),order.getOrder_user_id());
		TOrder t_order=(TOrder)MyDB.Query("select * from t_order order by order_id DESC LIMIT 0,1 ", TOrder.class);
		return t_order;
	}
	
	public void insertOrderIteam(TOrderitem orderitem) {
		MyDB.executeUpdate("insert into t_orderitem (order_id,goods_id,goods_quantity) value(?,?,?)", orderitem.getOrder_id(),orderitem.getGoods_id(),orderitem.getGoods_quantity());
	}
	
	public T_Good QueryGood(int goods_id) {
		T_Good good=(T_Good)MyDB.Query("select * from t_goods", T_Good.class);
		return good;
	}
	
	public void UpdateGood(T_Good good) {
		MyDB.executeUpdate("update t_goods set goods_kucun=? where goods_id=?", good.getGoods_kucun(),good.getGoods_id());
	}
	
}
