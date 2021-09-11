package demo_2021_9_10.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Demo1 {
    public static void main(String[] args) throws SQLException {
        //1创建 数据库连接对象
        DataSource ds=new ComboPooledDataSource();
        for (int i=1;i<=10;i++){
            Connection conn=ds.getConnection();
            System.out.println(i+" :->"+conn);
        }


    }
}
