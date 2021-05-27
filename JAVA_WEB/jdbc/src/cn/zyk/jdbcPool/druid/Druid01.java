package cn.zyk.jdbcPool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/*
druid的使用
1.still import jar
2.define properties:properties form
it could called any Name  ,located in any places
3.get connection  by class factory:  DruidDataSourceFactory
 */
public class Druid01 {
    public static void main(String[] args) {
        //1导包
        //2定义properties
        Properties pro=new Properties();
        InputStream in= Druid01.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(in);
            //3加载配置文件
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            Connection conn=ds.getConnection();
            System.out.println(conn);
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
