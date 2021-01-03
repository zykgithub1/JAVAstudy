package com.bjsxt.jdbc;

import java.sql.*;
import java.util.Random;

import com.mysql.jdbc.ResultSetInternalMethods;

//测试时间处理（java.sql.date,time,timestamp)；
//设置一个rand 而后时间对象-rand等于新随机时间
//并且加入了随机日期
public class Demo07 {
	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement ps1=null;
		//加载驱动类
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
			for(int i=0;i<1000;i++) {
				ps1=conn.prepareStatement("insert into t_user (username,pwd,regTime,lastLoginTime) values(?,?,?,?)");
				ps1.setObject(1, "增驿凯"+i);
				ps1.setObject(2, "123456");
				int rand=100000000+new Random().nextInt(1000000000);
				
				java.sql.Date date=new java.sql.Date(System.currentTimeMillis()-rand);
				Timestamp stamp=new Timestamp(System.currentTimeMillis()-rand);
				ps1.setObject(3, date);
				ps1.setTimestamp(4, stamp);
				ps1.execute();
			}


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(ps1!=null) {
					ps1.close();
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
