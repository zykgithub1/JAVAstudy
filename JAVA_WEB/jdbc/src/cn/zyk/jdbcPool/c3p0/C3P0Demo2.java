package cn.zyk.jdbcPool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
连接池参数的演示
 */
public class C3P0Demo2 {
    public static void main(String[] args) {
        DataSource ds =null;
        try {
            ds = new ComboPooledDataSource();
            for(int i=1;i<=10;i++){
                Connection conn =ds.getConnection();
                System.out.println(i+":"+conn);
                conn.close();
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {

        }
    }
}
