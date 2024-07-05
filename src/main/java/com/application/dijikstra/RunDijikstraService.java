package com.application.dijikstra;

import java.util.ArrayList;
import java.util.List;

public class RunDijikstraService {
    public static int run(int node){
        int size = locationsSize();
        ArrayList<ArrayList<Pair>> adjMatrix = getAdjList();
        int []distances = DijikstraImplementation.calculateShortestPathNode(adjMatrix,node ,size);
        return shortestPath(distances, node);
    }

    public static List<GraphComponent> getComponents(){
        return LocationHelper.adjacencyList();
    }

    public static ArrayList<ArrayList<Pair>> getAdjList(){
        List<GraphComponent> graphComponentList = getComponents();
        int size = locationsSize();
        return GraphFormatter.graphFormatter(graphComponentList,locationsSize());
    }

    public static int locationsSize(){
        return LocationHelper.getLocationSize();
    }

    public static int shortestPath(int []distances, int index){
        int minWeight = Integer.MAX_VALUE ;
        int minPathID = distances[0];
        for(int i = 0 ; i<distances.length; i++){
            if(i!=index){
                if(minWeight > distances[i]){
                    minWeight = distances[i];
                    minPathID = i ;
                }
            }
        }
        return minPathID;
    }
}
