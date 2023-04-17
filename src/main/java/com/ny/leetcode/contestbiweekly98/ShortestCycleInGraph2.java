package com.ny.leetcode.contestbiweekly98;

import com.ny.leetcode.ArrayUtil;

import java.util.*;

public class ShortestCycleInGraph2 {

    public static void main(String[] args) {
        ShortestCycleInGraph2 s = new ShortestCycleInGraph2();
        /*
        "talaqlt"
"tqla"
[4,3,3,-2]
         */
        System.out.println(s.findShortestCycle(7, ArrayUtil.read2D("[[0,1],[1,2],[2,0],[3,4],[4,5],[5,6],[6,3]]")));

    }

    public int findShortestCycle(int n, int[][] edges) {
        int res = -1;

        int[][] dp = new int[edges.length][2];
        Arrays.fill(dp, new int[]{-1, -1});

        for (int node = 0; node < edges.length; node++) {
            for (int neighbor = node, currentDistance = 0; neighbor != -1; neighbor = edges[neighbor][0]) {
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
