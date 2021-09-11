package demo_2021_9_10;

import utils.JDBCUtils;

import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

public class load {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("please input your name");

        String username=sc.nextLine();
        System.out.println("please input your password");
        String password=sc.nextLine();
        System.out.println(login2(username,password));
    }

    public static boolean login(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn =null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from user where username= '"+username+"' and password='"+password+"'";
            stmt=conn.createStatement();
            rs= stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return false;
    }
    /*
    preparestatment
     */
    public static boolean login2(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn =null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from user where username=? and password=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs= stmt.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return false;
    }
}
