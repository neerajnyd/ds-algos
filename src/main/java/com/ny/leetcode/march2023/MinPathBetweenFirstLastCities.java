package com.ny.leetcode.march2023;

import com.ny.leetcode.ArrayUtil;

import java.util.*;

public class MinPathBetweenFirstLastCities {

    public static void main(String[] args) {
        MinPathBetweenFirstLastCities c = new MinPathBetweenFirstLastCities();
        System.out.println(c.minScore(4, ArrayUtil.read2D("[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]")));

    }

    public int minScore(int n, int[][] roads) {

        Map<Integer, List<int[]>> adjacencyMatrix = createAdjacencyMatrix(roads);

        return bfs(n, adjacencyMatrix);
    }

    //n is not even required if we use a set instead of boolean array for visited
    private int bfs(int n, Map<Integer, List<int[]>> adj) {

        int result = Integer.MAX_VALUE;

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!Q.isEmpty()) {
            Integer node = Q.poll();
            if (!adj.containsKey(node)) continue;

            List<int[]> edges = adj.get(node);

            for (int[] edge : edges) {
                int neighbor = edge[0];
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    Q.add(neighbor);
                }
                int distance = edge[1];
                result = Math.min(result, distance);
            }
        }
        return result;
    }

    private Map<Integer, List<int[]>> createAdjacencyMatrix(int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] road : roads) {

            int cityA = road[0];
            int cityB = road[1];
            int dist = road[2];

            adj.computeIfAbsent(cityA, key -> new ArrayList<>()).add(new int[]{cityB, dist});
            adj.computeIfAbsent(cityB, key -> new ArrayList<>()).add(new int[]{cityA, dist});

        }
        return adj;
    }

    public int bfs2(int n, Map<Integer, List<List<Integer>>> adj) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        int answer = Integer.MAX_VALUE;

        q.offer(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (!adj.containsKey(node)) {
                continue;
            }
            for (List<Integer> edge : adj.get(node)) {
                answer = Math.min(answer, edge.get(1));
                if (!visit[edge.get(0)]) {
                    visit[edge.get(0)] = true;
                    q.offer(edge.get(0));
                }
            }
        }
        return answer;
    }
}
