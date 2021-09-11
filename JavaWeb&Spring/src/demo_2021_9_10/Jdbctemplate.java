package demo_2021_9_10;

import demo_2021_9_10.druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Jdbctemplate {
    public static void main(String[] args) {
        //创建jdbctemplate
        JdbcTemplate jtm=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="update student set balance =5000 where id=?";
        int count=jtm.update(sql,4);
        System.out.println(count);

    }
}
