package demo_2021_9_8_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo2 {
    public static void main(String[] args) throws Exception {
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="insert into student values('wangwu2','3000',4)";
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            stmt=conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if(count>0){
                System.out.println("执行成功");
            }else{
                System.out.println("fail");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
    }
}
