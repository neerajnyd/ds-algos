package com.ny.companies.goldmansachs;

import java.util.Arrays;

/*
all the ways to reach a given score if the possible runs are 2, 4, and 6
See Combination Sum 4 -> https://leetcode.com/problems/combination-sum-iv/
 */
public class DrawCricketGame {
    public static void main(String[] args) {
        System.out.println(noOfWaysToDraw(6));
    }

    public static int noOfWaysToDraw(int totalScore) {
        if (totalScore < 0) return 0;
        int[] scores = {2, 4, 6};
        int[] dp = new int[totalScore + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(scores, dp, totalScore);
    }

    private static int helper(int[] scores, int[] dp, int totalScore) {
        if (dp[totalScore] != -1) {
            return dp[totalScore];
        }
        int result = 0;
        for (int score : scores) {
            if (totalScore >= score) {
                result += helper(scores, dp, totalScore - score);
            }
        }
        dp[totalScore] = result;
        return result;
    }

    /*private static int noOfWaysToDraw(int totalScore) {
        int[] candidates = {2,4,6};
        List<List<Integer>> combinations = new ArrayList<>();
        helper(combinations, candidates, totalScore, new ArrayList<>(), 0);
        return combinations.size();
    }

    private static void helper(List<List<Integer>> combinations, int[] candidates, int remainingScore, List<Integer> tempList, int start) {
        if(remainingScore == 0) {
            combinations.add(new ArrayList<>(tempList));
        } else if(remainingScore < 0) return;

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            helper(combinations, candidates, remainingScore-candidates[i], tempList, i);
            tempList.remove(tempList.size()-1);
        }

    }*/


}
