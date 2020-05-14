package com.ny.leetcode;

import java.util.List;

public class LeftmostColumnWithAtLeastOneOne {

    public static int leftMostColumnWithOne2(BinaryMatrix M) {
        List<Integer> size = M.dimensions();
        int rows = size.get(0);
        int cols = size.get(1);
        boolean noOneFound = false;
        int loCol = 0, hiCol = cols - 1;
        int colWithOne = -1;
        while (loCol < hiCol) {
            int col = loCol + (hiCol - loCol) / 2;
            for (int row = 0; row < rows; row++) {
                if (M.get(row, col) == 1) {
                    colWithOne = col;
                    hiCol = col - 1;
                    break;
                }
            }
            if(colWithOne == -1) {
                loCol = col + 1;
            }
        }
        return colWithOne;
    }

    public static int leftMostColumnWithOne(BinaryMatrix M) {
        List<Integer> size = M.dimensions();
        int colWithOne = -1;
        int row = size.get(0)-1;
        int col = size.get(1)-1;
        while (row >=0 && col>=0) {
            if(M.get(row,col)==1) {
                colWithOne = col;
                col -= 1;
            } else {
                row -=1;
            }
        }
        return colWithOne;
    }

    interface BinaryMatrix {
        int get(int x, int y);

        List<Integer> dimensions();
    }

}
