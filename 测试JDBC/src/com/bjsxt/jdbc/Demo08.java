package com.bjsxt.jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

//测试时间处理（java.sql.date,time,timestamp)，取出指定时间区间的数据
//构造一个方法str2Date 将String时间格式转为时间对象
public class Demo08 {
	//将字符串代表的日期转为Long数字（格式：yyyy-MM-dd hh:mm:ss)
	public static long str2Date(String dateStr){
		DateFormat df=new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		try {
			return df.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}
	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//加载驱动类
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
//			ps=conn.prepareStatement("select * from t_user where regTime>? and regTime<?");
//			java.sql.Date star=new java.sql.Date(str2Date("2020-12-31 01:11:30"));
//			java.sql.Date end=new java.sql.Date(str2Date("2021-01-02 01:11:30"));
//			ps.setObject(1, star);
//			ps.setObject(2, end);
			ps=conn.prepareStatement("select * from t_user where lastLoginTime>? and lastLoginTime<? order by lastlogintime");
			Timestamp start=new Timestamp(str2Date("2020-12-28 10:10:20"));
			Timestamp end=new Timestamp(str2Date("2020-12-31 10:10:20"));
			ps.setObject(1, start);
			ps.setObject(2, end);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"---"+rs.getString("username")+"--"+rs.getTimestamp("lastLoginTime"));
			}
			


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
