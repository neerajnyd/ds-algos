package com.ny.leetcode.curatedlistchallenge.day6;

import com.ny.leetcode.domain.Graph;
import com.ny.leetcode.domain.GraphNode;

import java.util.*;

/*
https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

    /*
    [[2,4],[1,3],[2,4],[1,3]]
     */
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null) return null;
        if(node.neighbors.isEmpty()) return new GraphNode(node.val);

        return cloneHelper(node, new HashMap<>());
    }

    private static GraphNode cloneHelper(GraphNode node, Map<Integer, GraphNode> created) {
        if(created.containsKey(node.val)) return created.get(node.val);

        GraphNode node2 = new GraphNode(node.val); //new node from node
        created.put(node2.val, node2);
        List<GraphNode> neighbors2 = new ArrayList<>();
        for(GraphNode neighbor : node.neighbors) {
            GraphNode clonedNeighbor = cloneHelper(neighbor, created);
//            created.put(clonedNeighbor.val, clonedNeighbor);
            neighbors2.add(clonedNeighbor);
        }
        node2.neighbors = neighbors2;
        return node2;
    }

    public static void main(String[] args) {
        /*int[][] G = {{2,4},{1,3},{2,4},{1,3}};

        Graph graph = new Graph()

        GraphNode node = new GraphNode(G[0][0], new ArrayList<>(G[0][1]));

        for (int i = 1; i < G.length; i++) {
            int[] edge = G[i];

        }*/
    }
}
