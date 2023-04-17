package com.ny.leetcode.contest340;

import com.ny.leetcode.ArrayUtil;

import java.util.HashSet;
import java.util.Set;

public class One {

    public static void main(String[] args) {
        One o = new One();
        int[][] arr = ArrayUtil.read2D("[[1,2,3],[5,6,7],[9,10,11]]");
        int[][] arr2 = ArrayUtil.read2D("[[1,2,3],[5,17,7],[9,11,10]]");

        System.out.println(o.diagonalPrime(arr)); //11
        System.out.println(o.diagonalPrime(arr2)); //17
    }

    public int diagonalPrime(int[][] nums) {
        int max = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {

            int x = nums[i][i];
            int y = nums[i][j];
            if (x > max && isPrime(x)) {
                max = x;
            }
            if (y > max && isPrime(y)) {
                max = y;
            }

        }
        return max;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        // Check for factors
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
