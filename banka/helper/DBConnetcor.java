package com.banka.helper;

import java.sql.*;


public class DBConnetcor {

    public static final String url ="-----------------";
    public static final String username ="-----------";
    public static final String password="--------------";


    private Connection connection = null;

    public Connection connectDB(){
        try {
            connection = DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return this.connection;
    }

    public static Connection getInstance(){
        DBConnetcor db = new DBConnetcor();
        return db.connectDB();
    }
}
