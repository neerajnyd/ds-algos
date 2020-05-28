package com.ny.leetcode.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    Map<Integer, GraphNode> graph = new HashMap<>();

    public Graph(GraphNode node) {
        graph.put(node.val, node);
    }

    public GraphNode getNode(int n) {
        return graph.get(n);
    }

    /*public void addEdge(int x, int y) {
        if(graph.containsKey(x)) {
            GraphNode nodeX = graph.get(x);
            if(graph.containsKey(y)) {
                GraphNode nodeY = graph.get(y);
            }
            nodeX.neighbors.add(y);
        } else {
            ArrayList<GraphNode> neighbors = new ArrayList<>(y);
            graph.put(x, new GraphNode(x, neighbors));
        }
    }*/
}
