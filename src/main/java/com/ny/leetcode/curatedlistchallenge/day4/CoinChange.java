package com.ny.leetcode.curatedlistchallenge.day4;

import java.util.Arrays;

/*
https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(
                coinChange(
                        new int[]{186, 419, 83, 408}, 6249
                )
        );
    }

    public static int coinChange(int[] coins, int amount) {

        /* we don't want to make more than max */
        int max = amount + 1;

        //represents the number of coins required to create sum=index
        //so the indices represent the target value
        int[] dp = new int[max];

        //populate with a arbitrary large number for Math.min comparison
        Arrays.fill(dp, max);
        //it takes zero coins to make amount zero
        dp[0] = 0;

        //for each target amount from 0 to amount
        for (int i = 1; i < dp.length; i++)
            for (int c : coins) //check with each coin
                if (c <= i) //coins of value larger than target amount are not applicable
                    dp[i] = Math.min(dp[i], dp[i - c] + 1); //compare between the already present coin value AND the value obtained from using the current coin + coin value present at the remaining value

        return dp[amount] <= amount ? dp[amount] : -1;
    }

    public static int coinChange2(int[] coins, int target) {
        if (target < 1) return 0;
        return helper(coins, target, new int[target]);
    }

    private static int helper(int[] coins, int target, int[] count) {
        if (target < 0) return -1;
        if (target == 0) return 0;
        if (count[target - 1] != 0) return count[target - 1];
        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int res = helper(coins, target - c, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[target - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[target - 1];
    }
}
