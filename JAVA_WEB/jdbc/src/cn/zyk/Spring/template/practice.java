package cn.zyk.Spring.template;

import cn.zyk.utils.JDBCPollUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
(1)修改孙悟空的工资为10000
(2)添加一条记录
（3）删除刚才添加的记录
（4）查询id=1记录封装为map集合
（5）查询所有记录将其封装list
（6）查询所有的记录，将其封装为Emp对象的List集合
（7）查询总的记录数
 */
public class practice {
    public static void main(String[] args) {
        Properties pro = new Properties();
        InputStream is = practice.class.getClassLoader().getResourceAsStream("druid.properties");
//        ResultSet rs=null;
//        PreparedStatement stmt=null;
//        Connection conn=null;
        try {
            pro.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            JdbcTemplate template = new JdbcTemplate(ds);
            String sql = "update emp set salary=? where ename=?";
            int count = template.update(sql, 20000, "孙悟空");
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
