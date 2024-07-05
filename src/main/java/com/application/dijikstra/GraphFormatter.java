package com.application.dijikstra;

import java.util.ArrayList;
import java.util.List;

public class GraphFormatter {
    public static ArrayList<ArrayList<Pair>> graphFormatter(List<GraphComponent> graphComponentList, int size){
        ArrayList<ArrayList<Pair>> adjMatrix = new ArrayList<>() ;
        for(int i = 0 ; i<=size+1; i++){
            adjMatrix.add(new ArrayList<>());
        }

        for(int i = 0 ; i <graphComponentList.size(); i++){
            int id1 = graphComponentList.get(i).fromLocation;
            int id2 = graphComponentList.get(i).toLocation;
            int weight = graphComponentList.get(i).weight;
            adjMatrix.get(id1).add(new Pair(id2, weight));
            adjMatrix.get(id2).add(new Pair(id1, weight));
        }
        return adjMatrix;
    }
}
