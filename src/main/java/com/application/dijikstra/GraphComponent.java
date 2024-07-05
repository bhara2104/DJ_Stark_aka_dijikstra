package com.application.dijikstra;

public class GraphComponent {
    int fromLocation ;
    int toLocation ;
    int weight ;

    public GraphComponent(int fromLocation, int toLocation, int weight) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.weight = weight;
    }
}
