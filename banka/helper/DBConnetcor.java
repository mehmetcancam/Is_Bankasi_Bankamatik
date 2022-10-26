package com.banka.helper;

import java.sql.*;


public class DBConnetcor {

    public static final String url ="jdbc:postgresql://localhost/BANK_IS";
    public static final String username ="postgres";
    public static final String password="memoli123456";


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
