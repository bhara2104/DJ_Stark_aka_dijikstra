package com.application.dijikstra;

import java.util.*;

public class DijikstraImplementation {
    public static int[] calculateShortestPathNode(ArrayList<ArrayList<Pair>> adj, int node, int size) {
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

    public static ArrayList<Integer> calculateTheShortestPath(ArrayList<ArrayList<Pair>> adj, int start, int endVertex, int size) {
        int[] dist = new int[size + 2];
        int[] parent = new int[size + 2];
        for (int i = 1; i <= size; i++) {
            dist[i] = (int) (1e9);
            parent[i] = i;
        }
        ArrayList<Integer> path = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        dist[start] = 0;
        pq.add(new Pair(start,0));
        while (!pq.isEmpty()){
            int v = pq.peek().node;
            int weight = pq.peek().distance;
            pq.poll();
            for (int i = 0; i < adj.get(v).size(); i++) {
                int edgeWeight = adj.get(v).get(i).distance;
                int adjNode = adj.get(v).get(i).node;
                if (weight + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = weight + edgeWeight;
                    pq.add(new Pair(adjNode, weight + edgeWeight));
                    parent[adjNode] = v ;
                }
            }
        }

        if(dist[endVertex] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int node = endVertex;
        while(parent[node]!= node ){
            path.add(node);
            node = parent[node];
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
}

// How you will be picking up the driver in the way
// if(path.contains(startLocationofNewRide)){
// if(newRidePathFromAndPathMatches(path, newRideShortestPath)){
// Driver.notify(newRide)
// }
//}