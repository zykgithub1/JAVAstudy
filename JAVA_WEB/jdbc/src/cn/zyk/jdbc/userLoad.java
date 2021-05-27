package cn.zyk.jdbc;
/*
通过键盘录入用户民和密码
判断是否登录成功
 */

import cn.zyk.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class userLoad {
    public static void main(String[] args) {
        new userLoad().inputInfo();

    }
    public void inputInfo(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        boolean ans=new userLoad().login(username,password);
        if(ans==true){
            System.out.println("SUCCESS");
        }else {
            System.out.println("fail");
        }
    }


    public boolean login(String userName,String password){
        if(userName==null||password==null){
            return false;
        }
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from USER where username='"+userName+"'and password='"+password+"'";
            System.out.println(sql);
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()){
//                System.out.println(rs.getString("username")+"  "+rs.getString("password"));
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }  finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }
}
