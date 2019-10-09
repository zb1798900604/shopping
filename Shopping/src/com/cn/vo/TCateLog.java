package com.cn.vo;

public class TCateLog {
	private Integer catelog_id;
	private String catelog_name;
	private String catelog_miaoshu;
	private String catelog_del;
	
	public TCateLog() {
	}
	
	public Integer getCatelog_id() {
		return catelog_id;
	}

	public void setCatelog_id(Integer catelog_id) {
		this.catelog_id = catelog_id;
	}

	public String getCatelog_name() {
		return catelog_name;
	}
	public void setCatelog_name(String catelog_name) {
		this.catelog_name = catelog_name;
	}
	public String getCatelog_miaoshu() {
		return catelog_miaoshu;
	}
	public void setCatelog_miaoshu(String catelog_miaoshu) {
		this.catelog_miaoshu = catelog_miaoshu;
	}
	public String getCatelog_del() {
		return catelog_del;
	}
	public void setCatelog_del(String catelog_del) {
		this.catelog_del = catelog_del;
	}
}
