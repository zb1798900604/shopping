package com.cn.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MyDB {
	private MyDB() {}
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyypsc","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void close(AutoCloseable auto) {
		try {
			if(auto!=null)
				auto.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, Object>> executeQuery(String sql,Object...args) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1,args[i]);
			}
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()) {
				Map<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					map.put(rsmd.getColumnLabel(i),rs.getObject(i));
				}
				lists.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return lists;
	}
	
	public static void executeUpdate(String sql,Object...args) {
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1, args[i]);
			}
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
	}

	//查询商品详细信息的方法（可以给任意一个类）
	public static Object Query(String sql,Class<?> cla ,Object...args) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Object goods_obj=null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1,args[i]);
			}
			rs=ps.executeQuery();
			if(rs.next()) {
				goods_obj=invokObjec(cla,rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return goods_obj;
	}
	private static Object invokObjec(Class<?> cla,ResultSet rs) {
		Object obj=null;
		try {
			obj=cla.newInstance();//通过Class类类型创建对象
			Field[] fields = cla.getDeclaredFields();//获取所有对象属性
			for (Field field : fields) {
				String field_name=field.getName();
				Class<?> field_type=field.getType();
				String setterName="set"+field_name.substring(0,1).toUpperCase()+field_name.substring(1);
				Method method=cla.getMethod(setterName,field_type );
				if(method==null)
					continue;
				if(field_type==int.class||field_type==Integer.class) {
					method.invoke(obj,rs.getInt(field_name));
				}else if(field_type==String.class) {
					method.invoke(obj, rs.getString(field_name));
				}
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
