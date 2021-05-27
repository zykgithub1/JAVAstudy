package cn.zyk.jdbc;

import cn.zyk.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
sql注入
在拼接sql时，有一些sql的特殊关键字参与字符串的拼接会造成安全性问题
a' or 'a'='a    =>'a' or 'a'='a'
解决方法  prepareStateMent  预编译sql
参数使用？作为占位符
select * from USER where username=? and password=?
conn.prepareStateMent(String sql)要传参进来才创建对象 而statement不传参  这是区别
then：
给sql赋值  setXXX(参数1，参数2);-> 给问号赋值
prepareSatement 的execute方法不需要再次传参了

 */
public class sqlZhuru {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        boolean ans=new sqlZhuru().login(username,password);
        if(ans==true){
            System.out.println("SUCCESS");
        }else {
            System.out.println("fail");
        }
    }


    public boolean login(String username,String password){
        if(username==null||password==null){
            return false;
        }
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn= JDBCUtils.getConnection();
            String sql="select * from user where username=? and password =?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            return rs.next();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }
}
