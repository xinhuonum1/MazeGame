package Login;

import Tool.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register {
    private Register(){}
    public static String start(String username,String password){
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
                return "账号已存在";
            }else{
                String sql1="insert into java(username,password,max) values (?,?,?)";
                ps=conn.prepareStatement(sql1);
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setInt(3,0);
                int i=ps.executeUpdate();
                if(i>0){
                    return "注册成功";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Mysql.close(conn, ps, rs);
        }
        return null;
    }
}
