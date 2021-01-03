package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//测试执行sql语句，以及sql注入
public class Demo03 {
	public static void main(String[] args) {
		//加载驱动类
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
			String sql="insert into student (Sno,Sname) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setObject(1, "2017441284");
			ps.setObject(2, "曾二凯");
			System.out.println("插入一行记录");
			ps.execute();
			int count=ps.executeUpdate();
			System.out.println(count);

			
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
