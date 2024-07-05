package com.application.dijikstra;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private static final String URL = "jdbc:postgresql://localhost:5432/dijikstra_db" ;
    private static final String USERNAME = "bharathkumar" ;
    private static final String PASSWORD = "Bharath123";
    public static Connection connection;
    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
