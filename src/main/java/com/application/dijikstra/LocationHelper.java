package com.application.dijikstra;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LocationHelper {
    public static void adjacencyList(){
        String sql = "select * from adjacency_list" ;
        ResultSet resultSet ;
        try(PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql)){
            resultSet = preparedStatement.executeQuery();
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
