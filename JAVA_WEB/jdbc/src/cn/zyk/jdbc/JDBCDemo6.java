package cn.zyk.jdbc;

import java.sql.*;
import java.util.TreeMap;
//结果集对象  resultSet
//next 游标移动到下一行
//getXXX（参数）  XXX代表数据类型
//参数：（1）int=>代表列的编号从1开始
// （2）String getString（“balance”）

public class JDBCDemo6 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/traval","root","root");
            stmt=conn.createStatement();
            String sql="select * from account";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println
                        (rs.getInt("id")
                                +" "+rs.getDouble("balance")
                                +rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
