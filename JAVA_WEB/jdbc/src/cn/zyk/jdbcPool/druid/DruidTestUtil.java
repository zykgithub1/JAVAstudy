package cn.zyk.jdbcPool.druid;

import cn.zyk.utils.JDBCPollUtils;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//使用Pool工具类
public class DruidTestUtil {
    public static void main(String[] args) {
        /*
        完成一个添加的操作  给Account表
         */
        Connection conn=null;
        PreparedStatement psmt=null;
        try {
            conn=JDBCPollUtils.getConnection();
            String sql="insert into account values(null,?,?)";
            psmt=conn.prepareStatement(sql);
            psmt.setString(1,"zyk");
            psmt.setDouble(2,200000);
            int count = psmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCPollUtils.close(null,psmt,conn);
        }
    }
}
