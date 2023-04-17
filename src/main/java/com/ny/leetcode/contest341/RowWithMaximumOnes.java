package com.ny.leetcode.contest341;

import com.ny.leetcode.ArrayUtil;

public class RowWithMaximumOnes {

    public int[] rowAndMaximumOnes(int[][] mat) {

        int[] result = new int[2];
        int max = 0;
        int row = 0;

        for (int i = 0; i < mat.length; i++) {
            int ones = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    ones++;
                }
            }
            if (ones > max) {
                max = ones;
                row = i;
            }
        }
        result[0] = row;
        result[1] = max;
        return result;


    }


}
