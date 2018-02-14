package sample;

import dbUtil.dbConnection;

import java.sql.Connection;
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
    }
}
