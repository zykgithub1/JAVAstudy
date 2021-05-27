package cn.zyk.Spring.template;

import cn.zyk.utils.JDBCPollUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/*
创建jdbcTemplate 对象，依赖于数据源
jdbc Template=new jdbcTemplate(ds);
调用jdbcTemplate的方法来完成crud操作
！！！！！！常用方法
*  update():执行DML语句，Manipulation language
*  queryForMap():查询结果将结果集封装为map结合 ↓  ↓
  结果集大小只能为1 将列名作为key 将值作为value  一条message
*  queryForList():查询结果将结果集封装为list结合    把每个数据封装为一个map 在将map加进list
*  query:查询结果将结果封装为 javaBean对象
*  queryForObject():查询结果将结果封装为对象
 */
public class template {
    public static void main(String[] args) {
        //创建jdbc Template对象
        JdbcTemplate template=new JdbcTemplate(JDBCPollUtils.getDataSource());

        //调用对象
        String sql="update account set balance =5000 where id=?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }

}
