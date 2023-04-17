package com.ny.leetcode.contest338;

public class KItemsWithMaxSum {

    public static void main(String[] args) {
        KItemsWithMaxSum sum = new KItemsWithMaxSum();
        System.out.println(sum.kItemsWithMaximumSum(3, 2, 0, 4));
    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        if(numOnes >= k) return k;

        int sum = numOnes; //sum is less than k
        k -= numOnes;

        if(numZeros >= k) return sum;

        k-= numZeros;

        sum -= k;

        return sum;
    }



}
