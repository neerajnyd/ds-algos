package com.ny.leetcode.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/possible-bipartition/
 */
public class Day27_PossibleBipartition {
    public static void main(String[] args) {
        int N = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(possibleBipartition(N, dislikes));
        N = 3;
        dislikes = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println(possibleBipartition(N, dislikes));
        N = 5;
        dislikes = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        System.out.println(possibleBipartition(N, dislikes));

        N = 10;
        dislikes = new int[][]{{4, 7}, {4, 8}, {5, 6}, {1, 6}, {3, 7}, {2, 5}, {5, 8}, {1, 2}, {4, 9}, {6, 10}, {8, 10}, {3, 6},
                {2, 10}, {9, 10}, {3, 9}, {2, 3}, {1, 9}, {4, 6}, {5, 7}, {3, 8}, {1, 8}, {1, 7}, {2, 4}};
        System.out.println(possibleBipartition(N, dislikes));
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {

        Map<Integer, List<Integer>> graph = generateGraph(dislikes);

        Map<Integer, Integer> groupMap = new HashMap<>(); //null for -1, 0 for group A, 1 for group B

        for (int i = 1; i <= N; i++) {
            if (!groupMap.containsKey(i) && !dfs(graph, i, 0, groupMap)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, int src, int group, Map<Integer, Integer> groupMap) {
        if (groupMap.containsKey(src)) {
            if (groupMap.get(src) == 1 - group) {
                return false; // Found `src` in the competitor group
            }
            if (groupMap.get(src) == group) {
                return true; // Already visited
            }
        }
        groupMap.put(src, group);
        if (graph.containsKey(src)) {
            for (int v : graph.get(src)) {
                if (!dfs(graph, v, 1 - group, groupMap)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Map<Integer, List<Integer>> generateGraph(int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] d : dislikes) {
            int a = d[0], b = d[1];

            List<Integer> neighborsOfA = graph.getOrDefault(a, new ArrayList<>());
            List<Integer> neighborsOfB = graph.getOrDefault(b, new ArrayList<>());

            neighborsOfA.add(b);
            neighborsOfB.add(a);
            graph.put(a, neighborsOfA);
            graph.put(b, neighborsOfB);
        }
        return graph;
    }
}