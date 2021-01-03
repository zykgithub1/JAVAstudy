package com.bjsxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//���������ݿ⽨������
public class Demo01 {
	public static void main(String[] args) {
		//����������
		Connection conn=null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//��������(���Ӷ����ڲ���ʵ������Socket������һ��ѡ������ӣ��ȽϺ�ʱ��
			//����������Ϊ��Ч�ʣ�����ʹ�����ӳ����������
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
			long end=System.currentTimeMillis();
			System.out.println(conn);
			System.out.println("�������ӣ���ʱ"+(end-start)+"ms");
			
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
