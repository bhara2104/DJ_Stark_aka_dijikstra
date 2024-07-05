package com.application.dijikstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijistraImplementation {
    public static int[] calculateShortestPath(ArrayList<ArrayList<Pair>>adj, int node, int size){
        int dist[] = new int[size];
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        for(int i = 0 ; i < size; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[node] = 0 ;
        pq.add(new Pair(node, 0));
        while (pq.size()!=0){
            int v = pq.peek().node;
            int weight = pq.peek().distance;
            pq.poll();
            for(int i = 0 ; i<adj.get(v).size(); i++){
                int edgeWeight = adj.get(v).get(i).distance;
                int adjNode = adj.get(v).get(i).node;
                if(weight+edgeWeight < dist[adjNode]){
                    dist[adjNode] = weight + edgeWeight ;
                    pq.add(new Pair(weight+edgeWeight, adjNode));
                }
            }
        }
        return dist;
    }
}
