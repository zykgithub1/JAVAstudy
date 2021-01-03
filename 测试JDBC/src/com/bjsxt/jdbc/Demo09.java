package com.bjsxt.jdbc;

import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//测试CLOB文本大对象的使用  必须要reader流
public class Demo09 {

	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Reader r=null;
		//加载驱动类
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
	      	ps=conn.prepareStatement("insert into t_user(username,myInfo) values(?,?)");
	      	ps.setString(1, "曾驿凯");
	      	//ps.setClob(2, new FileReader(new File("d:/a.txt")));//将文本文件内容直接输入数据库中
	      	//将程序中的字符串输入到clob中
	      	//ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("zykno1handsome".getBytes()))));
	      	//ps.setClob(2, new InputStreamReader(new ByteArrayInputStream("zykagiantest".getBytes())));
	      	ps=conn.prepareStatement("select * from t_user where id=?");
	      	ps.setObject(1, 72009);
	      	rs=ps.executeQuery();
	      	while(rs.next()) {
	      		Clob c=rs.getClob("myInfo");
	      		r=c.getCharacterStream();
	      		int temp=0;
	      		while((temp=r.read())!=-1) {
	      			System.out.print((char)temp);
	      		}
	      	}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(r!=null) {
					r.close();
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
