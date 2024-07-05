package com.application.dijikstra;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocationHelper {
    public static List<GraphComponent> adjacencyList(){
        List<GraphComponent> list = new ArrayList<>();
        String sql = "select * from adjacency_list" ;
        ResultSet resultSet ;
        try(PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql)){
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new GraphComponent(resultSet.getInt("id1"), resultSet.getInt("id2"), resultSet.getInt("weight")));
            }
            resultSet.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static int getLocationSize(){
        int size = 0 ;
        String sql = "select count(id) from locations";
        ResultSet resultSet ;
        try(PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql)) {
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                size = resultSet.getInt("count");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return size;
    }
}
