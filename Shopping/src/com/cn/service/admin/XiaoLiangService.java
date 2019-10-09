package com.cn.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.T_Good;

public class XiaoLiangService {
	public List<T_Good> InitXiaoliang() {
		List<Map<String, Object>> list_map=MyDB.executeQuery("select * from t_goods as t INNER JOIN (select goods_id,SUM(goods_quantity) from t_orderitem  GROUP BY goods_id ORDER BY SUM(goods_quantity) desc )as o on t.goods_id=o.goods_id");
		List<T_Good> list=getAll(list_map);
		return list;
	}
	private List<T_Good> getAll(List<Map<String, Object>> map){
		List<T_Good> list=new ArrayList<T_Good>();
		for (Map<String, Object> tg : map) {
			T_Good tgood=new T_Good();
			tgood.setGoods_id((Integer)tg.get("goods_id"));
			tgood.setGoods_name(tg.get("goods_name").toString());
			tgood.setGoods_miaoshu(tg.get("goods_miaoshu").toString());
			tgood.setGoods_pic(tg.get("goods_pic").toString());
			tgood.setGoods_yanse(tg.get("goods_yanse").toString());
			tgood.setGoods_shichangjia((Integer)tg.get("goods_shichangjia"));
			tgood.setGoods_isnottejia(tg.get("goods_isnottejia").toString());
			tgood.setGoods_isnottuijian(tg.get("goods_isnottuijian")==null?null:tg.get("goods_isnottuijian").toString());
			tgood.setGoods_catelog_id((Integer)tg.get("goods_catelog_id"));
			tgood.setGoods_del(tg.get("goods_del").toString());
			tgood.setGoods_dianji((Integer)tg.get("goods_dianji"));
			tgood.setGoods_kucun((Integer)tg.get("goods_kucun"));
			list.add(tgood);
		}
		return list;
	}
}
