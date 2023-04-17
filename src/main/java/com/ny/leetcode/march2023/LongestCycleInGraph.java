package com.ny.leetcode.march2023;

import java.util.*;

public class LongestCycleInGraph {

    public int longestCycle(int[] edges) {
        int res = -1;

        int[][] dp = new int[edges.length][2];
        Arrays.fill(dp, new int[]{-1, -1});

        for (int node = 0; node < edges.length; node++) {
            for (int neighbor = node, currentDistance = 0; neighbor != -1; neighbor = edges[neighbor]) {
                int[] neighborDp = dp[neighbor];
                int distance = neighborDp[0]; //existing distance of neighbor
                int distanceFrom = neighborDp[1]; //distance from which node

                if (distance == -1) { //the usual case
                    dp[neighbor] = new int[]{currentDistance++, node}; //neighbor was encountered for the first time, reached from node
                    continue;
                }

                if (distanceFrom == node) { //reached node again - cycle
                    res = Math.max(res, currentDistance - distance);
                }
                break;
            }
        }
        return res;
    }


}
