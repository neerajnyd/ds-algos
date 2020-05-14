package com.ny.leetcode.curatedlistchallenge.day2;

/*
https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        //0 -> 1 -> 2
        /*
          |x|0|1|2|3|4|
          |0|0 1 2 3 5 <- the answer i.e. from 0 to 5
          |1|0 0 1 2 3      basically a fibonacci sequence
          |2|0 0 0 1 2
          |3|0 0 0 0 1
          |4|0 0 0 0 0
        */
        int a = 1;
        int b = 1;
        int c = b;
        for(int i=2; i<=n; i++) {
            c = a + b; //3
            a = b; //2
            b = c; //3
        }
        return c;
    }

}
