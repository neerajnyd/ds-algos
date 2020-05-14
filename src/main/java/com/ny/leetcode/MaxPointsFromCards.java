package com.ny.leetcode;

public class MaxPointsFromCards {

    public static void main(String[] args) {
        int[] cardPoints;
        int k;

        cardPoints = new int[]{11, 49, 100, 20, 86, 29, 72};
        k = 4;
        System.out.println(maxScore(cardPoints, k));

        cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
        k = 3;
        System.out.println(maxScore(cardPoints, k));

        cardPoints = new int[]{2, 2, 2};
        k = 2;
        System.out.println(maxScore(cardPoints, k));

        cardPoints = new int[]{9, 7, 7, 9, 7, 7, 9};
        k = 7;
        System.out.println(maxScore(cardPoints, k));

        cardPoints = new int[]{1, 1000, 1};
        k = 1;
        System.out.println(maxScore(cardPoints, k));

        cardPoints = new int[]{1, 79, 80, 1, 1, 1, 200, 1};
        k = 3;
        System.out.println(maxScore(cardPoints, k));

    }

    public static int maxScore(int[] points, int k) {
        int sum = 0; //sum of first k elements
        for (int i = 0; i < k; i++)
            sum += points[i];

        int max = sum;
        for (int i = 1; i <= k; i++) { //compare total k+1 sums – first one being max
            int pointsFromEnd = points[points.length - i];
            int pointsFromStart = points[k - i];
            sum = sum + pointsFromEnd - pointsFromStart;
            max = Math.max(max, sum);
        }

        return max;
    }

    public static int maxScore_Mine(int[] points, int k) {

        int[] startSum = new int[k];
        int[] endSum = new int[k];

        int n = points.length;
        for (int i = 0; i < k; i++) {
            if (i > 0)
                startSum[i] = points[i] + startSum[i - 1];
            else startSum[i] = points[i];
        }
        int x = 0;
        for (int i = n - 1; i >= n - k; i--) {
            if (i == n - 1) {
                endSum[x] = points[i];
            } else {
                endSum[x] = endSum[x - 1] + points[i];
            }
            x++;
        }

        int maxScore = Math.max(startSum[k - 1], endSum[k - 1]);
        for (int i = 0; i < k - 1; i++) {
            int x1 = i;
            int x2 = k - 1 - i - 1; //k - 1 elements in array
            int score = startSum[x1] + endSum[x2];
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public static int maxScore_TimeLimitExceeded(int[] points, int k) {

        int maxScore = 0;
        int n = points.length;
        for (int j = 0; j <= k; j++) {
            int score = 0;
            for (int i = 0; i < j; i++) {
                score += points[i];
            }
            for (int i = n - k + j; i < n; i++) {
                score += points[i];
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public static int maxScore_Wrong(int[] points, int k) {

        int s = 0, e = points.length - 1;
        int maxScore = 0;
        while (k > 0) {
            int p1 = points[s];
            int p2 = points[e];
            if (p1 > p2) {
                maxScore += p1;
                s++;
            } else {
                maxScore += p2;
                e--;
            }
            k--;
        }
        return maxScore;
    }

}
