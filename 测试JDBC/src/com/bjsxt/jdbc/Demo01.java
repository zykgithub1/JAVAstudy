package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//测试与数据库建立连接
public class Demo01 {
	public static void main(String[] args) {
		//加载驱动类
		Connection conn=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//建立连接(连接对象内部其实包含了Socket对象，是一个选择的链接，比较耗时）
			//真正开发中为了效率，都会使用连接池来管理对象）
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
			long end=System.currentTimeMillis();
			System.out.println(conn);
			System.out.println("建立连接：耗时"+(end-start)+"ms");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
