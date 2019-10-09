package com.cn.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.TLiuYan;

public class LiuyanManaAdminService {
	public List<TLiuYan> InitLiuYan() {
		//≤È—Ø¡Ù—‘
		List<Map<String, Object>> list_map=MyDB.executeQuery("select * from t_liuyan");
		List<TLiuYan> list=getAll(list_map);
		return list;
	}
	
	private List<TLiuYan> getAll(List<Map<String, Object>> map){
		List<TLiuYan> list=new ArrayList<TLiuYan>();
		for (Map<String, Object> tg : map) {
			TLiuYan tliuyan=new TLiuYan();
			tliuyan.setLiuyan_id((Integer)tg.get("liuyan_id"));
			tliuyan.setLiuyan_title(tg.get("liuyan_title").toString());
			tliuyan.setLiuyan_content(tg.get("liuyan_content").toString());
			tliuyan.setLiuyan_date(tg.get("liuyan_date").toString());
			tliuyan.setLiuyan_user(tg.get("liuyan_user").toString());
			list.add(tliuyan);
		}
		return list;
	}
	
	
	public void delLiuYan(int liuyanId ) {
		MyDB.executeUpdate("delete from t_liuyan where liuyan_id=?", liuyanId);
		
	}
}
