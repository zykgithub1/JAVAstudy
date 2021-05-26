package cn.zyk.utils;

import cn.zyk.domain.Emp;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
    private  static String url;
    private  static String user;
    private static String password;
    //不传递参数，还要保证工具类的通用性
    //通过配置文件来解决
    /*
    顶一个配置文件
    jdbc.properties->     url:    user:  password:
     */
    //获取连接的方法：

    //文件读取  使用静态代码块  读取资源文件
//    static {
//        try {
//            //properties集合类
//            Properties pro=new Properties();
//            //加载文件
////          pro.load(new FileReader("E:\\vsproject\\JAVA_WEB\\jdbc\\src\\jdbc.properties"));
//            //获取src路径下文件的方式  Classloader  类加载器
//            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
//            URL res = classLoader.getResource("jdbc.properties");
//            String path=res.getPath();
//            System.out.println(path);
//            pro.load(new FileReader(path));
//            //获取属性赋值
//            url=pro.getProperty("url");
//            user=pro.getProperty("user");
//            password=pro.getProperty("password");
//            Class.forName(pro.getProperty("driver"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    static {
        try{
            Properties pro=new Properties();
            InputStream in=JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(in);
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            Class.forName(pro.getProperty("driver"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //关闭，释放资源
    public static void close(Statement stmt,Connection conn){
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
    public static void close( ResultSet rs,Statement stmt, Connection conn){
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

    public static void main(String[] args) {
        List<Emp> ans=findAll();
        for(Emp temp:ans){
            System.out.println(temp);
        }
    }
}
