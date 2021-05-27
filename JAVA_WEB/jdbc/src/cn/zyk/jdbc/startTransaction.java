package cn.zyk.jdbc;

import cn.zyk.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
setAutoCommit false  即为事务开启
提交事务  commit
回滚 rollback
 */
public class startTransaction {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement psmt=null;
        PreparedStatement psmt2=null;
        ResultSet rs=null;
        try{
            conn= JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql1="update account set balance=balance- ?  where id=?";
            psmt=conn.prepareStatement(sql1);
            String sql2="update account set balance=balance+? where id=?";
            psmt2=conn.prepareStatement(sql2);
            psmt.setDouble(1,500);
            psmt.setInt(2,1);
            psmt2.setDouble(1,500);
            psmt2.setDouble(2,2);
            int ans1=psmt.executeUpdate();
            int i=3/0;
            int ans2=psmt2.executeUpdate();
            conn.commit();

        }catch (Exception e) {
            try {
                if(conn!=null){
                    conn.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(psmt,conn);
            JDBCUtils.close(psmt,null);
        }
    }
}
