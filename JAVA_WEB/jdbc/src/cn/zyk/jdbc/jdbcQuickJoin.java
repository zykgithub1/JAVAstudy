package cn.zyk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/*
 * 导入jdbc的jar包
 * DriverManager驱动管理对象
 * Connection 数据库连接对象:
 *      获取sql对象 prepareStatement statement
 *      管理事务：setAutoCommit  提交事务：commit   rollback回滚
 * StateMent 执行sql对象
 *      boolean  execute;了解
 *      int executeUpdate   执行DML（增删改:insert update delete），执行DDL（creat alter drop）语句
 *      通过返回值判断是否执行成功
 *      ResultSet executeQuery()           执行DQL语句（select）
 *
 * ResultSet结果集对象
 * PreparedStateMent:执行sql对象
 * 注册驱动
 * 获取数据库连接对象 Connection
 * 定义sql
 * 获取执行sql语句的对象  statement
 * 执行sql  接受返回结果
 * 处理结果
 * 释放资源
 */
public class jdbcQuickJoin {
    public static void main(String[] args) throws Exception {
        //1,复制jar包到项目的libs  而后右键 add as library
        //2，注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3,获取连接对象
        Connection conn=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/traval","root","root");
        //4定义一个sql语句
//        String sql="update account set balance=1100 where id=1";
        String sql="update account set balance=2200";
        //5获取执行sql的对象
        Statement stmt = conn.createStatement();
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //6执行sql
        int count = stmt.executeUpdate(sql);
        //7处理结果
        System.out.println(count);
        //8释放资源  statement 和 connect
        stmt.close();
        conn.close();
    }
}
