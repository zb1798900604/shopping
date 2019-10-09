package com.cn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.TCateLog;
import com.cn.vo.T_Good;
import com.cn.vo.Tgonggao;

public class IndexService {
	public List<T_Good> Init() {
		//获取新款上市前五条
		List<Map<String, Object>> list_map=MyDB.executeQuery("select * from t_goods where goods_del = ? ORDER BY goods_id DESC limit ?,?", "no",0,5);
		List<T_Good> list=getAll(list_map);
		return list;
	}
	//获取销量的前5条
	public List<T_Good> InitXiaoliang() {
		List<Map<String, Object>> list_map=MyDB.executeQuery("select * from t_goods as t INNER JOIN (select goods_id,SUM(goods_quantity) from t_orderitem  GROUP BY goods_id ORDER BY SUM(goods_quantity) desc LIMIT 0,5  )as o on t.goods_id=o.goods_id");
		List<T_Good> list=getAll(list_map);
		return list;
	}
	//获取商品类别
	public List<TCateLog> InitLiebei(){
		List<Map<String, Object>> list_map=MyDB.executeQuery("select * from t_catelog");
		List<TCateLog> list=getAllleibie(list_map);
		return list;
	}
	
	
	//获取公告
	public List<Tgonggao> InitGonggao(){
		List<Map<String, Object>> list_map=MyDB.executeQuery("select * from t_gonggao");
		List<Tgonggao> list=getAllGonggao(list_map);
		return list;
	}
	
	//获得所有商品
	public List<T_Good> GoodsAll() {
		//获取新款上市前五条
		List<Map<String, Object>> list_map=MyDB.executeQuery("select * from t_goods");
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
//			tgood.setGoods_isnottuijian(tg.get("goods_isnottuijian").toString());
			tgood.setGoods_catelog_id((Integer)tg.get("goods_catelog_id"));
			tgood.setGoods_del(tg.get("goods_del").toString());
			tgood.setGoods_dianji((Integer)tg.get("goods_dianji"));
			tgood.setGoods_kucun((Integer)tg.get("goods_kucun"));
			list.add(tgood);
		}
		return list;
	}
	//商品类别方法
	private List<TCateLog> getAllleibie(List<Map<String, Object>> map){
		List<TCateLog> list=new ArrayList<TCateLog>();
		for (Map<String, Object> tg : map) {
			TCateLog tCateLog=new TCateLog();
			tCateLog.setCatelog_id((Integer)tg.get("catelog_id"));
			tCateLog.setCatelog_name(tg.get("catelog_name").toString());
			tCateLog.setCatelog_miaoshu(tg.get("catelog_miaoshu").toString());
			tCateLog.setCatelog_del(tg.get("catelog_del").toString());
			list.add(tCateLog);
		}
		return list;
	}
	
	//公告
	private List<Tgonggao> getAllGonggao(List<Map<String, Object>> map){
		List<Tgonggao> list=new ArrayList<Tgonggao>();
		for(Map<String, Object> tg:map) {
			Tgonggao gg=new Tgonggao();
			gg.setGonggao_id((Integer)tg.get("gonggao_id"));
			gg.setGonggao_title(tg.get("gonggao_title").toString());
			gg.setGonggao_content(tg.get("gonggao_content").toString());
			gg.setGonggao_data(tg.get("gonggao_data").toString());
//			gg.setGonggao_fabuzhe(tg.get("gonggao_fabuzhe").toString());
//			gg.setGonggao_del(tg.get("gonggao_del").toString());
//			gg.setGonggao_one1(tg.get("gonggao_one1").toString());
//			gg.setGonggao_one2(tg.get("gonggao_one2").toString());
//			gg.setGonggao_one3(tg.get("gonggao_one3").toString());
//			gg.setGonggao_one4(tg.get("gonggao_one4").toString());
//			gg.setGonggao_one5(tg.get("gonggao_one5").toString());
			list.add(gg);
		}
		return list;
		
	}
	
	
}
