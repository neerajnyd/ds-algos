package com.ny.leetcode.march2023;

import com.ny.leetcode.ArrayUtil;

import java.util.*;

public class ReorderToLeadToRootNode {

    public static void main(String[] args) {
        ReorderToLeadToRootNode c = new ReorderToLeadToRootNode();
        System.out.println(c.minReorder(4, ArrayUtil.read2D("[[0,1],[1,3],[2,3],[4,0],[4,5]]")));

    }

    int count = 0;

    public int minReorder(int n, int[][] connections) {
        /*
        treat graph as undirected but distinguish between nodes that were original (reachable = true) and not originally reachable
        end state is such that the parent node 0 (and others as well) are not reachable from children nodes
        when traversing from 0 to all other nodes, if child node is reachable -> increase count of edge to reverse
         */
        Map<Integer, List<Neighbor>> adj = new HashMap<>();

        for (int[] c : connections) {
            adj.computeIfAbsent(c[0], k -> new ArrayList<>()).add(
                    new Neighbor(c[1], true)); //
            adj.computeIfAbsent(c[1], k -> new ArrayList<>()).add(
                    new Neighbor(c[0], false));
        }
// we don't need to run this in a loop because connected components = 1 as we are treating the graph as undirected
        dfs(0, -1, adj);
        return count;
    }

    public void dfs(int thisNode, int parent, Map<Integer, List<Neighbor>> adj) {
        if (!adj.containsKey(thisNode)) return;

        for (Neighbor neighbor : adj.get(thisNode)) {
            int neighborNode = neighbor.node;
            boolean reachable = neighbor.reachable; //we want children nodes to not be reachable in the final version
            if (neighborNode != parent) { // for when the direction is reversed
                count += reachable ? 1 : 0; //if it was reachable from node then that means we reverse the direction, add 1 to result
                dfs(neighborNode, thisNode, adj);
            }
        }
    }

    private static class Neighbor {
        private final int node;
        private final boolean reachable;

        private Neighbor(int node, boolean reachable) {
            this.node = node;
            this.reachable = reachable;
        }
    }
}
