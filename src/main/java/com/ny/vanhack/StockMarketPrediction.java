package com.ny.vanhack;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StockMarketPrediction {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("C:\\Users\\local1\\Downloads\\input001.txt"));
        int pCount = in.nextInt();
        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < pCount; i++) {
            prices.add(in.nextInt());
        }
        int qCount = in.nextInt();
        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < qCount; i++) {
            queries.add(in.nextInt());
        }

        List<Integer> predictions = predictAnswer(prices, queries);
        for (Integer p : predictions) {
            System.out.println(p);
        }
    }

    public static List<Integer> predictAnswer(List<Integer> prices, List<Integer> days) {
        List<Integer> result = new ArrayList<>();

        int[] dpL = filLeftDp(prices);
        int[] dpR = filRightDp(prices);

        for (int day : days) {
            int dayIndex = day - 1;
            int leftSmallest = dpL[dayIndex];
            int rightSmallest = dpR[dayIndex];

            if(leftSmallest == -1 && rightSmallest == -1) {
                result.add(-1);
            } else if (leftSmallest == -1) {
                result.add(rightSmallest + 1);
            } else if (rightSmallest == -1) {
                result.add(leftSmallest + 1);
            } else {
                int diffL = dayIndex - leftSmallest;
                int diffR = rightSmallest - dayIndex;
                result.add(diffL <= diffR ? leftSmallest+1 : rightSmallest+1);
            }
        }
        return result;
    }

    private static int[] filLeftDp(List<Integer> prices) {
        int[] dp = new int[prices.size()];
        Arrays.fill(dp, -1);

        for (int i = 1; i < prices.size(); i++) {
            int price = prices.get(i);

            int left = i - 1;
            while (left >= 0) {
                Integer leftPrice = prices.get(left);
                if (leftPrice >= price) {
                    if (dp[left] == -1) {
                        dp[i] = -1;
                        break;
                    } else {
                        left = dp[left]; //
                    }
                } else {
                    dp[i] = left;
                    break;
                }
            }
        }
        return dp;
    }

    private static int[] filRightDp(List<Integer> prices) {
        int[] dp = new int[prices.size()];
        Arrays.fill(dp, -1);

        for (int i = prices.size() - 2; i >= 0; i--) {
            int price = prices.get(i);

            int right = i + 1;
            while (right < prices.size()) {
                Integer rightPrice = prices.get(right);
                if (rightPrice >= price) {
                    if (dp[right] == -1) {
                        dp[i] = -1;
                        break;
                    } else {
                        right = dp[right]; //
                    }
                } else {
                    dp[i] = right;
                    break;
                }
            }
        }
        return dp;
    }

    public static List<Integer> predictAnswer2(List<Integer> prices, List<Integer> days) {
        List<Integer> result = new ArrayList<>();
        outer:
        for (Integer dayIndex : days) {
            int d = dayIndex - 1;
            Integer price = prices.get(d);
            int leftIndex = d - 1;
            int rightIndex = d + 1;
            while (leftIndex >= 0 || rightIndex < prices.size()) {
                if (leftIndex >= 0) {
                    if (prices.get(leftIndex) < price) {
                        result.add(leftIndex + 1);
                        continue outer;
                    }
                    leftIndex--;
                }
                if (rightIndex < prices.size()) {
                    if (prices.get(rightIndex) < price) {
                        result.add(rightIndex + 1);
                        continue outer;
                    }
                    rightIndex++;
                }
            }
            result.add(-1);
        }
        return result;
    }


}
