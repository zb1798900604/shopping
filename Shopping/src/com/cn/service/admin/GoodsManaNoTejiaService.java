package com.cn.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.T_Good;

/*
 * 查询所有商品
 */
public class GoodsManaNoTejiaService {
	public List<T_Good> queryGoods(){
		List<Map<String, Object>> list=MyDB.executeQuery("select * from t_goods");
		List<T_Good> list_goods=getAll(list);
		return list_goods;
	}
	public List<T_Good> queryGoodId(int goodsId){
		List<Map<String, Object>> list=MyDB.executeQuery("select * from t_goods where goods_id=?",goodsId);
		List<T_Good> list_goods=getAll(list);
		return list_goods;
	}
	private List<T_Good> getAll(List<Map<String, Object>> map){
		List<T_Good> list_good=new ArrayList<T_Good>();
		for (Map<String, Object> map1 : map) {
			T_Good tg=new T_Good();
			tg.setGoods_id((Integer)map1.get("goods_id"));
			tg.setGoods_name(map1.get("goods_name").toString());
			tg.setGoods_miaoshu(map1.get("goods_miaoshu").toString());
			tg.setGoods_pic(map1.get("goods_pic").toString());
			tg.setGoods_yanse(map1.get("goods_yanse").toString());
			tg.setGoods_shichangjia((Integer)map1.get("goods_shichangjia"));
			tg.setGoods_isnottejia(map1.get("goods_isnottejia").toString());
			tg.setGoods_isnottuijian(map1.get("goods_isnottuijian")==null?null:map1.get("goods_isnottuijian").toString());
			tg.setGoods_catelog_id((Integer)map1.get("goods_catelog_id"));
			tg.setGoods_del(map1.get("goods_del").toString());
			tg.setGoods_dianji((Integer)map1.get("goods_dianji"));
			tg.setGoods_kucun((Integer)map1.get("goods_kucun"));
			list_good.add(tg);
		}
		return list_good;
	}
	
	
}
