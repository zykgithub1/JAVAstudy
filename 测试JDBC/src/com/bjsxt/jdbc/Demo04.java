package com.bjsxt.jdbc;

import java.sql.*;


import com.mysql.jdbc.ResultSetInternalMethods;

//测试resultset结果集的基本用法；
public class Demo04 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//加载驱动类
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "root");
			String sql="select Sno,Ssex,sname from student where Sage>?";
			ps=conn.prepareStatement(sql);
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"--------"+rs.getObject(2)+"--------"+rs.getObject(3));//1,2表示 select的列数
			}

			
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
