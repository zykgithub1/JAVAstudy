package JDBCexperiments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.*;

public class Test01 {
	public static void main(String[] args){
		
		Connection conn=null;
		PreparedStatement ps=null; 
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
			String sql="select * from course where 课程号=?";
			ps=conn.prepareStatement(sql);
			ps.setObject(1, 1001);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getObject("课程号")+"---"+rs.getObject("课程名称")+"--"+rs.getObject("学分")+"--"+rs.getObject("开课学院"));
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
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
