package com.ny.dynamicprogramming;

public class MinPriceBetweenStations {

    public static void main(String[] args) {

        int[][] costs = {
                {0, 10, 75, 94, 120},
                {-1, 0, 35, 50, 200},
                {-1, -1, 0, 80, 95},
                {-1, -1, -1, 0, 40},
                {-1, -1, -1, -1, 0}
        };
//        System.out.println(minCostBetweenStations(costs, 0, 4));
//        System.out.println(minCostBetweenStations_topDownRecursive(costs, 0, 4));
        System.out.println(minCostBetweenStations_BottomUp(costs, 0, 4));
    }

    //TODO: ?
    private static int minCostBetweenStations_BottomUp(int[][] costs, int s, int d) {

        int N = costs.length;
        int[] minCost = new int[N];

        minCost[0] = 0;
        minCost[1] = costs[0][1];

        for (int i = 2; i < N; i++) {
            minCost[i] = costs[0][i];
            for (int j = 1; j < i; j++) {
                minCost[i] = Math.min(minCost[i], minCost[j] + costs[i][j]);
            }
        }
        return minCost[N -1];
    }

    private static int minCostBetweenStations_topDownRecursive(int[][] costs, int s, int d) {

        int[][] dp = new int[costs.length][costs.length]; //n * n cost array
        return topDownRecursiveHelper(costs, s, d, dp);
    }

    private static int topDownRecursiveHelper(int[][] costs, int s, int d, int[][] dp) {
        //if the stations are the same or the destination is the next station
        if (s == d || s == d - 1) {
            return costs[s][d];
        }
        if (dp[s][d] != 0){
            System.out.println("Value " + dp[s][d] + " already calculated for " + s + " to " + d);
            return dp[s][d]; //pre calculated value - just return
        }

        int min = costs[s][d];
        //i starts from s+1 because we calc cost from s to i AND i to d
        // -> i has to start from next station
        for (int i = s + 1; i < d; i++) {
            /* cost of going from s to i and then i to d */
            int cost = topDownRecursiveHelper(costs, s, i, dp) + topDownRecursiveHelper(costs, i, d, dp);
            min = Math.min(min, cost);
        }
        dp[s][d] = min;
        return dp[s][d];
    }

    private static int minCostBetweenStations_Recursive(int[][] costs, int s, int d) {
        System.out.println("Source is " + s + ". Destination is " + d);
        if (s == d || s == d - 1) return costs[s][d];

        int min = costs[s][d];

        for (int i = s + 1; i < d; i++) {
            int cost1 = minCostBetweenStations_Recursive(costs, s, i);
            int cost2 = minCostBetweenStations_Recursive(costs, i, d);
            int temp = cost1 + cost2;
            if (temp < min)
                min = temp;
        }
        return min;
    }






}
