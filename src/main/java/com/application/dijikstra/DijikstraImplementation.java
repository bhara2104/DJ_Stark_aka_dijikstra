package com.application.dijikstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijikstraImplementation {
    public static int[] calculateShortestPath(ArrayList<ArrayList<Pair>> adj, int node, int size) {
        int[] dist = new int[size + 2];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node] = 0;
        pq.add(new Pair(node, 0));
        while (!pq.isEmpty()) {
            int v = pq.peek().node;
            int weight = pq.peek().distance;
            pq.poll();
            for (int i = 0; i < adj.get(v).size(); i++) {
                int edgeWeight = adj.get(v).get(i).distance;
                int adjNode = adj.get(v).get(i).node;
                if (weight + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = weight + edgeWeight;
                    pq.add(new Pair(adjNode, weight + edgeWeight));
                }
            }
        }
        return dist;
    }
}
