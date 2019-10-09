package com.cn.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.TOrder;
import com.cn.vo.TOrderitem;
import com.cn.vo.T_Good;
import com.cn.vo.Tuser;

public class OrderManaService {
	public List<TOrder> getOrder(){
		List<Map<String, Object>>  list=MyDB.executeQuery("select * from t_order");
		List<TOrder> list_to=getAll(list);
		return list_to;
	}
	
	private List<TOrder> getAll(List<Map<String, Object>> map){
		List<TOrder> list_to=new ArrayList<TOrder>();
		for(Map<String, Object> map1:map) {
			TOrder to=new TOrder();
			to.setOrder_id((Integer)map1.get("order_id"));
			to.setOrder_bianhao(map1.get("order_bianhao").toString());
			to.setOrder_date(map1.get("order_date").toString());
			to.setOrder_zhuangtai(map1.get("order_zhuangtai").toString());
			to.setOrder_jine((Integer)map1.get("order_jine"));
			to.setOrder_songhuodizhi(map1.get("order_songhuodizhi").toString());
			to.setOrder_fukuangfangshi(map1.get("order_fukuangfangshi").toString());
			to.setOrder_user_id((Integer)map1.get("order_user_id"));
			list_to.add(to);
		}
		return list_to;
	}
	
	public void delOrder(int id) {
		MyDB.executeUpdate("delete from t_order where order_id=?", id);
	}
	
	//根据id查询用户
	public Tuser TuserALL(int id){
		List<Map<String, Object>>  list=MyDB.executeQuery("select * from t_user where user_id=?",id);
		List<Tuser> list_tu=getAllUser(list);
		
		Tuser t_user = new Tuser();
		for(Tuser t:list_tu) {
			t_user.setUser_id(t.getUser_id());
            t_user.setUser_name(t.getUser_name());
            t_user.setUser_pw(t.getUser_pw());
            t_user.setUser_type(t.getUser_type());
            t_user.setUser_realname(t.getUser_realname());
            t_user.setUser_address(t.getUser_address());
            t_user.setUser_sex(t.getUser_sex());
            t_user.setUser_tel(t.getUser_tel());
            t_user.setUser_email(t.getUser_email());
            t_user.setUser_qq(t.getUser_qq());
            t_user.setUser_man(t.getUser_man());
            t_user.setUser_age(t.getUser_age());
            t_user.setUser_birthday(t.getUser_birthday());
            t_user.setUser_xueli(t.getUser_xueli());
            t_user.setUser_del(t.getUser_del());
            t_user.setUser_one1(t.getUser_one1());
            t_user.setUser_one2(t.getUser_one2());
            t_user.setUser_one3(t.getUser_one3());
            t_user.setUser_one4(t.getUser_one4());
            t_user.setUser_one5(t.getUser_one5());
            t_user.setUser_one6(t.getUser_one6());
            t_user.setUser_one7(t.getUser_one7());
            t_user.setUser_one8(t.getUser_one8());
            t_user.setUser_one9(t.getUser_one9());
            t_user.setUser_one10(t.getUser_one10());
            t_user.setUser_one11(t.getUser_one11());
            t_user.setUser_one12(t.getUser_one12());
			
		}
		return t_user;
	}
	private List<Tuser> getAllUser(List<Map<String, Object>> map){
		List<Tuser> user_list=new ArrayList<Tuser>();
		for(Map<String,Object> temp : map) {
            Tuser t_user = new Tuser();
            t_user.setUser_id((Integer)temp.get("user_id"));
            t_user.setUser_name(temp.get("user_name").toString());
            t_user.setUser_pw(temp.get("user_pw").toString());
            t_user.setUser_type((Integer)temp.get("user_type"));
            t_user.setUser_realname(temp.get("user_realname").toString());
            t_user.setUser_address(temp.get("user_address").toString());
            t_user.setUser_sex(temp.get("user_sex").toString());
            t_user.setUser_tel(temp.get("user_tel")==null?null:temp.get("user_tel").toString());
            t_user.setUser_email(temp.get("user_email").toString());
            t_user.setUser_qq(temp.get("user_qq").toString());
            t_user.setUser_man(temp.get("user_man")==null?null:temp.get("user_man").toString());
            t_user.setUser_age(temp.get("user_age")==null?null:temp.get("user_age").toString());
            t_user.setUser_birthday(temp.get("user_birthday")==null?null:temp.get("user_birthday").toString());
            t_user.setUser_xueli(temp.get("user_xueli")==null?null:temp.get("user_xueli").toString());
            t_user.setUser_del(temp.get("user_del")==null?null:temp.get("user_del").toString());
            t_user.setUser_one1(temp.get("user_one1")==null?null:temp.get("user_one1").toString());
            t_user.setUser_one2(temp.get("user_one2")==null?null:temp.get("user_one2").toString());
            t_user.setUser_one3(temp.get("user_one3")==null?null:temp.get("user_one3").toString());
            t_user.setUser_one4(temp.get("user_one4")==null?null:temp.get("user_one4").toString());
            t_user.setUser_one5(temp.get("user_one5")==null?null:temp.get("user_one5").toString());
            t_user.setUser_one6(temp.get("user_one6")==null?0:(Integer)temp.get("user_one6"));
            t_user.setUser_one7(temp.get("user_one7")==null?0:(Integer)temp.get("user_one7"));
            t_user.setUser_one8(temp.get("user_one8")==null?0:(Integer)temp.get("user_one8"));
            t_user.setUser_one9(temp.get("user_one9")==null?null:temp.get("user_one9").toString());
            t_user.setUser_one10(temp.get("user_one10")==null?null:temp.get("user_one10").toString());
            t_user.setUser_one11(temp.get("user_one11")==null?0:(Integer)temp.get("user_one11"));
            t_user.setUser_one12(temp.get("user_one12")==null?0:(Integer)temp.get("user_one12"));
            user_list.add(t_user);
        }
		return user_list;
	}
	
	//受理订单
	public void SouLi(int orderId ) {
		MyDB.executeUpdate("UPDATE t_order SET order_zhuangtai ='yes' WHERE order_id=?",orderId);
	}
	
	
	
	//订单明细
	public List<TOrderitem> getOrder(int orderId) {
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
