package com.application.dijikstra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        //int size = locationsSize();
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

    public static String shortestPathFromVertices(int startNode , int endNode){
        int size = locationsSize();
        ArrayList<ArrayList<Pair>> adjMatrix = getAdjList();
        ArrayList<Integer> path = DijikstraImplementation.calculateTheShortestPath(adjMatrix,startNode,endNode,size);
        return path.stream().map(Object::toString).collect(Collectors.joining("-> "));
    }
}
