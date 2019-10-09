package com.cn.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.TCateLog;

public class CatelogManaService {
	public List<TCateLog> query() {
		List<Map<String, Object>> list=MyDB.executeQuery("select * FROM t_catelog ");
		List<TCateLog> list_tc=getAll(list);
		return list_tc;
	}
	
	private List<TCateLog> getAll(List<Map<String, Object>> map){
		List<TCateLog> list=new ArrayList<TCateLog>();
		for(Map<String, Object> map1:map) {
			TCateLog tc=new TCateLog();
			tc.setCatelog_id((Integer)map1.get("catelog_id") );
			tc.setCatelog_name(map1.get("catelog_name").toString());
			tc.setCatelog_miaoshu(map1.get("catelog_miaoshu").toString());
			tc.setCatelog_del(map1.get("catelog_del").toString());
			list.add(tc);
		}
		return list;
	}
}
