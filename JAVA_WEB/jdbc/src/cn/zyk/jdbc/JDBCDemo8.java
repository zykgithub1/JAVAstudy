package cn.zyk.jdbc;

import cn.zyk.domain.Emp;
import cn.zyk.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo8 {
    /*
    查询所有Emp对象
     */
    public  static List<Emp> findAll(){
        List<Emp>ans=new ArrayList<>();
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql:///test","root","root");
            stmt=conn.createStatement();
            String sql="select * from emp";
            rs=stmt.executeQuery(sql);
            Emp emp=null;
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("ename");
                int job_id=rs.getInt("job_id");
                int mgr=rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary=rs.getDouble("salary");
                double bouns=rs.getDouble("bonus");
                int dept_id=rs.getInt("dept_id");
                emp=new Emp(id,name,job_id,mgr,joindate,salary,bouns,dept_id);
                ans.add(emp);
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
        return ans;
    }


    public  static List<Emp> findAll2(){
        List<Emp>ans=new ArrayList<>();
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtils.getConnection();
            conn= DriverManager.getConnection("jdbc:mysql:///test","root","root");
            stmt=conn.createStatement();
            String sql="select * from emp";
            rs=stmt.executeQuery(sql);
            Emp emp=null;
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("ename");
                int job_id=rs.getInt("job_id");
                int mgr=rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary=rs.getDouble("salary");
                double bouns=rs.getDouble("bonus");
                int dept_id=rs.getInt("dept_id");
                emp=new Emp(id,name,job_id,mgr,joindate,salary,bouns,dept_id);
                ans.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return ans;
    }


    public static void main(String[] args) {
        List<Emp> ans=findAll2();
        for(Emp temp:ans){
            System.out.println(temp);
        }
    }
}
