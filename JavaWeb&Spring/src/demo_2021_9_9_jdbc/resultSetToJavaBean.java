package demo_2021_9_9_jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class resultSetToJavaBean {
    public static void main(String[] args) {
        List<Emp> list = new resultSetToJavaBean().findAll();
        System.out.println(list);
    }
    public List<Emp> findAll(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        List<Emp>ans=new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            String sql="select * from emp";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            Emp emp=null;
            while(rs.next()){
                int id=rs.getInt("id");
                String ename=rs.getString("ename");
                int job_id=rs.getInt("job_id");
                int mgr=rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp=new Emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id);
                ans.add(emp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ans;
    }
}
