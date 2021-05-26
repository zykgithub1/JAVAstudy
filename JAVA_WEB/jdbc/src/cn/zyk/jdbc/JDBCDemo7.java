package cn.zyk.jdbc;

import java.sql.*;
//查询 test数据库下emp表的数据 而后封装为对象，装在集合中
/*
定义emp类
定义方法public List<EMP> findAll(){}
实现方法  select * from
 */

public class JDBCDemo7 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/test","root","root");
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
