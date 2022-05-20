package Login;

import Play.BeginPlay;
import Tool.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Save {
    private Save(){}
    public static String start(String username,int max){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Mysql.getConnection();
            String sql="update java set max=? where username=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,max);
            ps.setString(2,username);
            int i=ps.executeUpdate();
            if(i>0){
                    return "保存成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Mysql.close(conn, ps, rs);
        }
        return null;
    }
}
