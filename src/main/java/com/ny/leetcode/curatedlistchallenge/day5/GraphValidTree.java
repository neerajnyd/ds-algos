package com.ny.leetcode.curatedlistchallenge.day5;

import java.util.*;

/*
https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphValidTree {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {1, 4}, {1, 3}
        };
        System.out.println(validTree_bfs2(n, edges));
    }

    public boolean validTree(int n, int[][] edges) {

        // Create an adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);

        while (!Q.isEmpty()) {
            int vertexId = Q.poll();

            if (visited[vertexId]) {
                return false;
            }

            visited[vertexId] = true;

            for (int neighbor : adjList.get(vertexId)) {
                if (!visited[neighbor]) {
                    Q.offer(neighbor);
                }
            }
        }

        // Check the islands
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private static boolean validTree_bfs2(int n, int[][] edges) {

        if (edges.length == 0) return n == 1;

        Map<Integer, List<Integer>> G = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            List<Integer> neighborsOfX = G.getOrDefault(x, new ArrayList<>());
            List<Integer> neighborsOfY = G.getOrDefault(y, new ArrayList<>());
            neighborsOfX.add(y);
            neighborsOfY.add(x);
            G.put(x, neighborsOfX);
            G.put(y, neighborsOfY);
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(edges[0][0]); //the very first element

        Set<Integer> V = new HashSet<>();
        V.add(edges[0][0]);

        int visitedCount = 0; //when Q becomes empty this should be equal to n

        while (!Q.isEmpty()) {
            int x = Q.poll();
            visitedCount++;

            List<Integer> neighborsOfX = G.get(x);
            for (int y : neighborsOfX) {
                if (Q.contains(y))
                    return false;

                if (!V.contains(y)) {
                    Q.offer(y);
                    V.add(y);
                }
            }
        }
        return visitedCount == n;
    }

    public static boolean validTree_bfs(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 1;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> neighbors1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> neighbors2 = graph.getOrDefault(edge[1], new ArrayList<>());
            neighbors1.add(edge[1]);
            neighbors2.add(edge[0]);
            graph.put(edge[0], neighbors1);
            graph.put(edge[1], neighbors2);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(edges[0][0]);
        Set<Integer> visited = new HashSet<>();
        visited.add(edges[0][0]);

        int nodes = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodes++;

            for (int neighbor : graph.get(node)) {
                if (queue.contains(neighbor))
                    return false;

                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return nodes == n;
    }
}
