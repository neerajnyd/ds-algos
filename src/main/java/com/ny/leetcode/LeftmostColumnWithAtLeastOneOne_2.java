package com.ny.leetcode;

import java.util.List;

public class LeftmostColumnWithAtLeastOneOne_2 {

    public static void main(String[] args) {
        int[][] M = {{0,0}, {0,1}};
//        int[][] M = {{0,0,0,1},{0,0,1,1},{0,1,1,1}};
        System.out.println(leftMostColumnWithOne(M));
    }

    public static int leftMostColumnWithOne(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;

        int loCol = 0, hiCol = cols - 1;
        int colWithOne = -1;
        int equalCount = 0;
        while (loCol <= hiCol) {
            int col = (hiCol + loCol) / 2;
            for (int row = 0; row < rows; row++) {
                if (M[row][col] == 1) {
                    colWithOne = col;
                    hiCol = col - 1;
                    break;
                }
            }
            if(colWithOne == -1) {
                loCol = col + 1;
            }
            if(loCol == hiCol){
                equalCount++;
                if(equalCount > 1) break;
            }
        }
        return colWithOne;
    }

}
