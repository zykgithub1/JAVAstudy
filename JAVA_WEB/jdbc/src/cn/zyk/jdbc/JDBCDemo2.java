package cn.zyk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //定义sql
            String sql="insert into account values(null,'王五',3000)";
            conn= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/traval","root","root");
            //获取statement对象
            stmt=conn.createStatement();
            int count=stmt.executeUpdate(sql);
            System.out.println(count);
            if(count>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
