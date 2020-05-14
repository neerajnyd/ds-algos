package com.ny.leetcode;

public class MyPow {

    public static void main(String[] args) {
        double x = 2.00;
        int n = -10;

        double ans = myPow(x, n);
        System.out.println(ans);
    }

    private static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if( n == Integer.MIN_VALUE ) {
                ++n;
                n = -n;
                x = 1/x;
                return x * x * myPow( x * x, n / 2 );
            }
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

}
