package demo_2021_9_10.druid;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class druidDemo {
    public static void main(String[] args) throws Exception {
        //导入jar包
        //定义配置文件
        //加载配置文件
        //获取连接对象
        Properties pro=new Properties();
        InputStream is = druidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn=ds.getConnection();
        System.out.println(conn);
    }
}
