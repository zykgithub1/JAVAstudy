package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//测试statement接口
//测试执行sql语句，以及sql注入
public class Demo02 {
	public static void main(String[] args) {
		//加载驱动类
		Connection conn=null;
		Statement stmt=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
		    stmt=conn.createStatement();
			String sql="insert into student (Sno,Sname,Ssex,Sage,Sdept) values(2015441284,'曾驿凯','男',24,'CS')";
			stmt.execute(sql);
		    //测试sql注入
//		    String sql="delete from student where Sno=2015441284";
//			stmt.execute(sql);

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
