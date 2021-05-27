package cn.zyk.Spring.template;
//junit     来测试


import cn.zyk.domain.Emp;
import cn.zyk.domain.Empp;
import cn.zyk.utils.JDBCPollUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/*
(1)修改孙悟空的工资为10000
(2)添加一条记录
（3）删除刚才添加的记录
（4）查询id=1记录封装为map集合
（5）查询所有记录将其封装list
（6）查询所有的记录，将其封装为Emp对象的List集合
（7）查询总的记录数
 */
public class JdbcTemplateDemo1 {
    //Junit 单元测试  让方法可以独立执行 不依赖与主方法
    private JdbcTemplate template=new JdbcTemplate(JDBCPollUtils.getDataSource());


    //(1)修改孙悟空的工资为10000
    @Test
    public void test1(){

        String sql="update emp set salary =? where ename=?";
        int count = template.update(sql, 10000, "孙悟空");
        System.out.println(count);
    }

    //(2)添加一条记录
    @Test
    public void test2(){
        String sql="insert into emp(id,ename,dept_id) values(1015,'增益开',10)";
        int count = template.update(sql);
        System.out.println(count);
    }

    //（3）删除刚才添加的记录
    @Test
    public void test3(){
        String sql="delete  from emp where id=?";
        int count = template.update(sql,1015);
        System.out.println(count);
    }
    @Test
    //（4）查询id=1记录封装为map集合
    public void test4(){
        String sql="select * from emp where ename='孙悟空'";
        Map<String, Object> ans = template.queryForMap(sql);
        System.out.println(ans);
    }



    @Test
    //（5）查询所有记录将其封装list
    public void test5(){
        String sql="select * from emp";
        List<Map<String, Object>> ans = template.queryForList(sql);
        for(Map temp:ans){
            System.out.println(temp);
        }
    }


    @Test
    //查询所有记录将记录封装为 Emp对象 然后加入list集合   自己实现EMP对象封装  麻烦！！！！！
    public void test6(){
        String sql="select * from emp";
        List<Emp> ans = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");
                Emp emp = new Emp(id, ename, job_id,
                        mgr, joindate, salary, bonus, dept_id);
                return emp;
            }
        });
        for(Emp emp:ans){
            System.out.println(emp);
        }

    }
    @Test
    //还是上个问题 不自己实现Emp封装
    public void test7(){
        String sql="select * from emp";
        List<Empp> ans =template.query(sql, new BeanPropertyRowMapper<Empp>(Empp.class));

        for(Empp emp:ans){
            System.out.println(emp);
        }

    }

    @Test
    //查询总记录数
    public void test8(){
        String sql="select count(id) from  emp";
        Long total = template.queryForObject(sql, long.class);
        System.out.println(total);

    }
}
