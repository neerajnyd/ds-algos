package com.ny.pramp;

import java.util.*;

public class Two_FindPairsWithGivenDifference {

    public static void main(String[] args) {
        int[] A = {0, -1, -2, 2, 1};
        int t = 1;

        System.out.println(Arrays.deepToString(
                findPairsWithGivenDifference_Brute(A, t))
        );System.out.println(Arrays.deepToString(
                findPairsWithGivenDifference(A, t))
        );



    }

    /*
    k = x - y
    x = k + y
    y = x - k
    input: [0, -1, -2, 2, 1], k = 1
    output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
    */
    public static int[][] findPairsWithGivenDifference_Brute(int[] A, int k) {

        List<int[]> R = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int smallerNum = A[i];
            for (int j = 0; j < A.length; j++) {
                if(i==j) continue;
                int largerNum = smallerNum + k;
                if(A[j] == largerNum) {
                    R.add(new int[]{largerNum, smallerNum});
                }
            }
        }

        int[][] result = new int[R.size()][2];
        for (int i = 0; i < R.size(); i++)
            result[i] = R.get(i);
        return result;
    }

    public static int[][] findPairsWithGivenDifference(int[] A, int k) {

        Set<Integer> set = new HashSet<>();
        for (int a : A) set.add(a);

        List<int[]> R = new ArrayList<>();
        for (int smallerNum : A) {
            int largerNum = smallerNum + k;
            if (set.contains(largerNum)) {
                R.add(new int[]{largerNum, smallerNum});
            }
        }

        int[][] result = new int[R.size()][2];
        for (int i = 0; i < R.size(); i++)
            result[i] = R.get(i);
        return result;
    }

}
