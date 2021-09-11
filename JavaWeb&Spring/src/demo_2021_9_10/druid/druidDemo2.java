package demo_2021_9_10.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class druidDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="insert into student values(null,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"zhangsan");
            pstmt.setDouble(2,3000);
            int count=pstmt.executeUpdate();
            System.out.println(count);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.close(null,pstmt,conn);
        }
    }
}
