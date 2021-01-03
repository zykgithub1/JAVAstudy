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

//测试使用JDBC工具类
public class Demo11 {

	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		//加载驱动类
		try {
			conn=JDBCUtil.getMysqlConn();
			ps=conn.prepareStatement("insert into t_user (username) values(?)");
			ps.setString(1, "赠一开");
			ps.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);

		}
	}
}
