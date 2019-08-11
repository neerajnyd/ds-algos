package com.ny.leetcode;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SolTwo {

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
        long L = 0, R = 0;
        int STEP_SIZE = 0;

        L = sc.nextLong();
        R = sc.nextLong();
        STEP_SIZE = sc.nextInt();

        int mines = sc.nextInt();
        long[] arr = new long[mines];
        for(int i=0; i<mines; i++)
            arr[i] = sc.nextLong();
        solve(L, R, STEP_SIZE, arr, mines);
    }

    private static void solve(long L, long R, int step, long[] positions, int mineCount){
        Arrays.sort(positions);
        long lastMine = positions[mineCount-1];
        int c1 = 0, c2 = 0;
        for(long position : positions) {
            for (long j = L; j <= lastMine; j+=step) {
                if(position == j) c1++;
            }
            for (long j = R; j <= lastMine; j+=step) {
                if(position == j) c2++;
            }
        }


        System.out.print(c1 + " " + c2);
    }
}
