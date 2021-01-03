package com.bjsxt.jdbc;

import java.sql.*;


import com.mysql.jdbc.ResultSetInternalMethods;

//测试批处理的基本用法；stmt.addbatch  --->stmt.executebatch
//使用statement 因为预编译空间有限
public class Demo05 {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//加载驱动类
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
			conn.setAutoCommit(false);//事物设置为手动提交
			long start=System.currentTimeMillis();
			stmt=conn.createStatement();
			for(int i=1;i<20000;i++) {
				stmt.addBatch("insert into t_user (username,pwd,regTime) values('zyk"+i+"',6666,now())");
			}
			stmt.executeBatch();
			conn.commit();
			long end=System.currentTimeMillis();
			System.out.println("插入两万条数据，耗时为"+(end-start)+"毫秒");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null) {
					stmt.close();
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
