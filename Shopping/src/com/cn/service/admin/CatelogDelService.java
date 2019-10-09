package com.cn.service.admin;

import com.cn.util.MyDB;

/**
 * É¾³ý
 *
 */
public class CatelogDelService {
	public void delCatelog(int catelogId) {
		MyDB.executeUpdate("delete from t_catelog where catelog_id=?", catelogId);
	}
}
