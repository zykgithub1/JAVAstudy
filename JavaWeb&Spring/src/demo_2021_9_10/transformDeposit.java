package demo_2021_9_10;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class transformDeposit {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstm1=null;
        PreparedStatement pstm2=null;
        ResultSet rs=null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql="update student set balance=balance-? where id=?";
            String sql2="update student set balance=balance+? where id=?";
            pstm1=conn.prepareStatement(sql);
            pstm2=conn.prepareStatement(sql2);
//            conn.setAutoCommit(false);
            pstm1.setDouble(1,500);
            pstm1.setInt(2,1);
            pstm2.setDouble(1,500);
            pstm2.setInt(2,2);
            pstm1.executeUpdate();
            int i=3/0;
            pstm2.executeUpdate();
            conn.commit();
        } catch (SQLException throwables) {
            try {
               if(conn!=null){
                   conn.rollback();
               }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(pstm1,conn);
            JDBCUtils.close(pstm2,null);
        }

    }
}
