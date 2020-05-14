package com.ny.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverseII {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
    }

    //TODO:
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0;
        int maxCols = 0;
        final int rows = nums.size();

        for(List<Integer> list : nums) {
            n += list.size();
            maxCols = Math.max(list.size(), maxCols);
        }
        int[] R = new int[n];
        int row = 0;
        int col = 0;
        for(int i=0; i<n; i++) {

            List<Integer> numRow = nums.get(row);
            int rowLength = numRow.size();
            if(rowLength == col + 1) {
                R[i++] = numRow.get(col);
            }
            if(row -1 < 0) {
                row = row + 1;
            } else {
                row--;
            }
//            if(col + 1 == maxCols)


        }

        return R;

    }

}
