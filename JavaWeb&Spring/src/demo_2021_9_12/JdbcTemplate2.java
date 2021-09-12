package demo_2021_9_12;

import demo_2021_9_10.druid.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplate2 {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    //junit 单元测试
    @Test
    public void test1(){
//        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="update emp set salary =10000 where id=?";
        int count = template.update(sql,1001);
        System.out.println(count);
    }

    @Test
    public void test2(){
        String sql="insert into emp(id,ename,dept_id) values(?,?,?)";
        int co = template.update(sql,1013,"黄蓉",15);
        System.out.println(co);
    }

    @Test
    public void test3(){
        String sql="delete  from emp where id=?";
        int co = template.update(sql,1013);
        System.out.println(co);
    }

    /*
    queryForMap only get one result
     */
    @Test
    public void test4(){
        String sql="select * from emp where id=? or id=?";
        Map<String, Object> map = template.queryForMap(sql,1001,1002);
        System.out.println(map);
    }

    /*
    query all info
     */
    @Test
    public void test5(){
        String sql="select * from emp ";
        List<Map<String, Object>> maps = template.queryForList(sql);
        System.out.println(maps);
    }

    @Test
    public void test6(){
        String sql="select * from emp ";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp(rs.getInt("id"),
                        rs.getString("ename"),
                        rs.getInt("job_id"),
                        rs.getInt("mgr"),
                        rs.getDate("joindate"),
                        rs.getDouble("salary"),
                        rs.getDouble("bonus"),
                        rs.getInt("dept_id")
                );
                return emp;
            }
        });
        for(Emp em:list){
            System.out.println(em);
        }
    }

    @Test
    public void test6_2(){
        String sql="select * from emp ";
        List<Empp> list = template.query(sql, new BeanPropertyRowMapper<Empp>(Empp.class));
        for(Empp em:list){
            System.out.println(em);
        }
    }

    @Test
    public void test7(){
        String sql="select count(id) from emp ";
        Long res = template.queryForObject(sql,Long.class);
        System.out.println(res);
    }
}
