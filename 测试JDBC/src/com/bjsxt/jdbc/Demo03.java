package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//����ִ��sql��䣬�Լ�sqlע��
public class Demo03 {
	public static void main(String[] args) {
		//����������
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
			String sql="insert into student (Sno,Sname) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setObject(1, "2017441284");
			ps.setObject(2, "������");
			System.out.println("����һ�м�¼");
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
