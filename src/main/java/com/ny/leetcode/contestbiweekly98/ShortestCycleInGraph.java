package com.ny.leetcode.contestbiweekly98;

import com.ny.gfg.linkedlist.LL;
import com.ny.leetcode.ArrayUtil;

import java.util.*;

public class ShortestCycleInGraph {

    public static void main(String[] args) {
        ShortestCycleInGraph s = new ShortestCycleInGraph();
        /*
        "talaqlt"
"tqla"
[4,3,3,-2]
         */
        System.out.println(s.findShortestCycle(5, ArrayUtil.read2D("[[2,1],[0,1],[4,1],[3,0],[1,3]]")));
//        System.out.println(s.findShortestCycle(7, ArrayUtil.read2D("[[0,1],[1,2],[2,0],[3,4],[4,5],[5,6],[6,3]]")));

    }

    int count = 0;

    public int findShortestCycle(int n, int[][] edges) {

        Map<Integer, List<Integer>> adj = createAdjacencyMatrix(edges);
        int min = 1001;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        while (!Q.isEmpty()) {
            boolean[] visited = new boolean[n];
            count = 1;
            int size = Q.size();

            for (int i = 0; i < size; i++) {

                Integer node = Q.poll();
                visited[node] = true;
                count++;
                if (adj.containsKey(node)) continue;

                List<Integer> neighbors = adj.get(node);

                for (Integer neighbor : neighbors) {
                    if(!visited[neighbor]) {
                        Q.add(neighbor);
                    } else {

                    }

                }
            }




        }

        return min == 1001 ? -1 : min;

    }


    private Map<Integer, List<Integer>> createAdjacencyMatrix(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {

            int v1 = edge[0];
            int v2 = edge[1];

            adj.computeIfAbsent(v1, key -> new ArrayList<>()).add(v2);
            adj.computeIfAbsent(v2, key -> new ArrayList<>()).add(v1);

        }
        return adj;
    }

}
