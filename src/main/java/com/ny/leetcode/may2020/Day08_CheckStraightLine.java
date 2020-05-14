package com.ny.leetcode.may2020;

public class Day08_CheckStraightLine {

    public boolean checkStraightLine(int[][] C) {
        if (C.length < 3) return false;

        int x0 = C[0][0];
        int y0 = C[0][1];

        int xS = C[1][0] - x0; /* x component of slope */
        int yS = C[1][1] - y0; /* y component of slope */

        for (int i = 2; i < C.length; i++) {

            int xSi = C[i][0] - x0; /* x component of slope */
            int ySi = C[i][1] - y0;/* y component of slope */
            long i1 = xSi * xSi;
            /* xSi/ySi should be equal to xS/yS OR */
            if (xSi * yS != ySi * xS) return false;
        }

        return true;
    }

}
