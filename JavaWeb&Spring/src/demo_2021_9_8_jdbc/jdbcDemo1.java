package demo_2021_9_8_jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
//        String sql = "update student set balance = 500 where id=1";
        String sql = "update student set balance = 2000";
        Statement stmt = conn.createStatement();
//        conn.setAutoCommit(false);
//        conn.rollback();
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        stmt.close();
        conn.close();
    }
}
