package com.bjsxt.jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//����BLOB�����ƴ�����ʹ��
public class Demo10 {

	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		InputStream is=null;
		OutputStream os=null;
		//����������
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
	      	ps=conn.prepareStatement("select * from t_user where id=?");
	      	ps.setObject(1,72011);
	      	rs=ps.executeQuery();
	      	while(rs.next()) {
	      		Blob b=rs.getBlob("headImg");
	      		is=b.getBinaryStream();
	      		os=new FileOutputStream(new File("d:/111.png"));
	      		int temp=0;
	      		while((temp=is.read())!=-1) {
	      			os.write(temp);
	      		}
	      		os.flush();
	      	}
	      	
//	      	ps.setString(1, "���俭");��һ��ͷ��
//	      	ps.setBlob(2, new FileInputStream(new File("d:/ball.png")));
//	      	ps.execute();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(is!=null) {
					is.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(os!=null) {
					os.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
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
