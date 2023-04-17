package com.ny.leetcode.march2023;

public class MinCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {


        int lastDay = days[days.length - 1];

        int[] dp = new int[lastDay + 1];
        int j = 0;
        for (int i = 1; i < dp.length; i++) {

            if (i == days[j]) {
                j++;
                int oneDayPass = getCost(dp, i - 1) + costs[0];//buy one day pass today and add yesterday's cost (the minimum cost yesterday)
                int sevenDayPass = getCost(dp, i - 7) + costs[1];//buy seven day pass today and add seven days earlier min cost
                int thirtyDayPass = getCost(dp, i - 30) + costs[2];//buy thirty day pass today and add thirty days earlier min cost
                dp[i] = Math.min(Math.min(oneDayPass, sevenDayPass), thirtyDayPass);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    private static int getCost(int[] dp, int i) {
        return i < 0 ? 0 : dp[i];
    }


}
