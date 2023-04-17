package com.ny.leetcode.march2023;

import com.ny.leetcode.ArrayUtil;

import java.util.*;

public class MinOpsToConnectNetwork {

    public static void main(String[] args) {
        MinOpsToConnectNetwork c = new MinOpsToConnectNetwork();
        System.out.println(c.makeConnected(4, ArrayUtil.read2D("[[0,1],[0,2],[1,2]]")));

    }

    public int makeConnected(int n, int[][] connections) {

        //we need n-1 connections to connect n nodes
        if (connections.length < n - 1) return -1;

        /* for c un-components in the graph, we need c-1 connections to connect them,
        so essentially we need to find the total unconnected components c and return c-1
        */

        Map<Integer, List<Integer>> adjacencyMatrix = createAdjacencyMatrix(connections);

        int c = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                c++; //increment only for those nodes that were not visited by some previous node using dfs/bfs
//                dfs(i, adjacencyMatrix, visited);
                bfs(i, adjacencyMatrix, visited);
            }
        }
        return c - 1;
    }

    private void bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {

            Integer val = queue.poll();
            if (!adj.containsKey(val)) continue;
            for (Integer i : adj.get(val)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    private void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {

        visited[node] = true;
        if (!adj.containsKey(node)) return;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(neighbor, adj, visited);
            }
        }
    }

    private Map<Integer, List<Integer>> createAdjacencyMatrix(int[][] roads) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] road : roads) {

            int cityA = road[0];
            int cityB = road[1];

            adj.computeIfAbsent(cityA, key -> new ArrayList<>()).add(cityB);
            adj.computeIfAbsent(cityB, key -> new ArrayList<>()).add(cityA);

        }
        return adj;
    }
}
