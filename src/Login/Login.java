package Login;

import Tool.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    private Login(){}
    public static boolean start(String username,String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Mysql.getConnection();
            String sql = "select password from java where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
           if(rs.next()) {
                String password1=rs.getString(1);
                if(password.equals(password1))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Mysql.close(conn, ps, rs);
        }
        return false;
    }
}
