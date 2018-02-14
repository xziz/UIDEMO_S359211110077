package sample;

import dbUtil.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginModel {
    Connection connection;

    public loginModel() {

        try {
            this.connection = dbConnection.getConnection();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        if (this.connection == null){
            System.exit(1);
        }
    }

    public boolean isDatabaseconnecttion(){
        return this.connection != null;
    } //isDatabase

    public boolean isLogin(String user, String pass) throws SQLException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        //sql
        String sql = "select * from user where username = ? and password = ?";
        try{
            pr = this.connection.prepareStatement(sql);
            pr.setString(1,user);
            pr.setString(2,pass);

            rs = pr.executeQuery();
            if (rs.next()){
                return true;
            }
            return false;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally {
            pr.close();
            rs.close();
        }
    } //isLogin

}
//