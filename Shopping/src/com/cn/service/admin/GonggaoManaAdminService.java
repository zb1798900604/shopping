package com.cn.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.Tgonggao;

public class GonggaoManaAdminService {
	public List<Tgonggao> getALLGonggao(){
		List<Map<String, Object>> list=	MyDB.executeQuery("select * from t_gonggao");
		List<Tgonggao> listgg=getALL(list);
		
		return listgg;
		
	}
	private List<Tgonggao> getALL(List<Map<String, Object>> map){
		List<Tgonggao> list=new ArrayList<Tgonggao>();
		for(Map<String, Object> map1:map) {
			Tgonggao tg=new Tgonggao();
			tg.setGonggao_id((Integer)map1.get("gonggao_id"));
			tg.setGonggao_title(map1.get("gonggao_title").toString());
			tg.setGonggao_content(map1.get("gonggao_content").toString());
			tg.setGonggao_data(map1.get("gonggao_data").toString());
			tg.setGonggao_fabuzhe(map1.get("gonggao_fabuzhe")==null?null:map1.get("gonggao_fabuzhe").toString());
			tg.setGonggao_del(map1.get("gonggao_del")==null?null:map1.get("gonggao_del").toString());
			tg.setGonggao_one1(map1.get("gonggao_one1")==null?null:map1.get("gonggao_one1").toString());
			tg.setGonggao_one2(map1.get("gonggao_one2")==null?null:map1.get("gonggao_one2").toString());
			tg.setGonggao_one3(map1.get("gonggao_one3")==null?null:map1.get("gonggao_one3").toString());
			tg.setGonggao_one4(map1.get("gonggao_one4")==null?null:map1.get("gonggao_one4").toString());
			tg.setGonggao_one5(map1.get("gonggao_one5").toString());
			tg.setGonggao_one6(map1.get("gonggao_one6").toString());
			tg.setGonggao_one7((Integer)map1.get("gonggao_one7")==null?null:(Integer)map1.get("gonggao_one7"));
			tg.setGonggao_one8((Integer)map1.get("gonggao_one8")==null?null:(Integer)map1.get("gonggao_one8"));
			
			list.add(tg);
		}
		return list;
	}
	
	public void delGonggao(int gonggaoId) {
		MyDB.executeUpdate("delete from t_gonggao where gonggao_id=?", gonggaoId);
	}
	public Tgonggao queryGG(int gonggaoId) {
		List<Map<String, Object>> list=MyDB.executeQuery("select * from t_gonggao where gonggao_id=?", gonggaoId);
		List<Tgonggao> listgg=getALL(list);
		Tgonggao tg=new Tgonggao();
		for(Tgonggao tgg:listgg) {
			tg.setGonggao_id(tgg.getGonggao_id());
			tg.setGonggao_title(tgg.getGonggao_title());
			tg.setGonggao_content(tgg.getGonggao_content());
			tg.setGonggao_data(tgg.getGonggao_data());
			tg.setGonggao_fabuzhe(tgg.getGonggao_fabuzhe());
			tg.setGonggao_del(tgg.getGonggao_del());
			tg.setGonggao_one1(tgg.getGonggao_one1());
			tg.setGonggao_one2(tgg.getGonggao_one2());
			tg.setGonggao_one3(tgg.getGonggao_one3());
			tg.setGonggao_one4(tgg.getGonggao_one4());
			tg.setGonggao_one5(tgg.getGonggao_one5());
			tg.setGonggao_one6(tgg.getGonggao_one6());
			tg.setGonggao_one7(tgg.getGonggao_one7());
			tg.setGonggao_one8(tgg.getGonggao_one8());
		}
		return tg;
	}
	public void insertGG(String gonggaoTitle,String gonggaoContent) {
		MyDB.executeUpdate("INSERT INTO t_gonggao (gonggao_title, gonggao_content,gonggao_one5,gonggao_one6) "
				+ "VALUES (?, ?,2019-18-06,2019-10-10 00:00:00) ", gonggaoTitle,gonggaoContent);
		
	}
	
}
