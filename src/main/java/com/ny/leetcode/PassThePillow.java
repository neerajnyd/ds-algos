package com.ny.leetcode;

public class PassThePillow {

    public static void main(String[] args) {

        System.out.println(passThePillow(18, 38));
        System.out.println(passThePillow(4, 5));

    }

    public static int passThePillow(int n, int time) {


        //n - 1 time to reach the end
        //2n - 2 time to reach the beginning

       /* int end = n - 1;
        int begin = 2*n - 2;

        if(time / end == 0) { //pillow hasn't reached the end
            return time + 1;
        } else if (time / begin == 0) { //pillow hasn't reached the beinning
            return time - n + 1;
        } else {

            int nearEndOrBegin = time % end;
            if(nearEndOrBegin % 2 == 0)

        }*/

        int t = time % (2*n-2);
        if(t < n) {
            //only forward direction
            int i = 1;
            while (t > 0) {
                i++;
                t--;
            }
            return i;
        } else {
            t = time % (n -1);
            int i = n;
            while (t > 0) {
                i--;
                t--;
            }
            return i;
        }

    }
}
