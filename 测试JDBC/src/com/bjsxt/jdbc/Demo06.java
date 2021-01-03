package com.bjsxt.jdbc;

import java.sql.*;


import com.mysql.jdbc.ResultSetInternalMethods;

//��������rollback��
public class Demo06 {
	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		//����������
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
			conn.setAutoCommit(false);
			ps1=conn.prepareStatement("insert into t_user (username,pwd) values(?,?)");
			ps1.setObject(1, "��һ��");
			ps1.setObject(2, "123456");
			ps1.execute();
			System.out.println("����һ���û�-��һ��");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ps2=conn.prepareStatement("insert into t_user (username,pwd) values(?,?)");
			ps2.setObject(1, "����");
			ps2.setObject(2, "123456");
			ps2.execute();
			System.out.println("����һ���û�-����");

			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
