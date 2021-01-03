package com.bjsxt.jdbc;

import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//����CLOB�ı�������ʹ��  ����Ҫreader��
public class Demo09 {

	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Reader r=null;
		//����������
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
	      	ps=conn.prepareStatement("insert into t_user(username,myInfo) values(?,?)");
	      	ps.setString(1, "���俭");
	      	//ps.setClob(2, new FileReader(new File("d:/a.txt")));//���ı��ļ�����ֱ���������ݿ���
	      	//�������е��ַ������뵽clob��
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
