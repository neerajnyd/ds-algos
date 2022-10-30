package com.ny.leetcode.curated.array;

public class BestTimeBuySellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(
                maxProfit(prices)
        );
    }

    private static int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int maxProfit = 0;

        int minPrice = prices[0];

        for(int price : prices) {

            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit, profit);


        }
        return maxProfit;
    }

}
