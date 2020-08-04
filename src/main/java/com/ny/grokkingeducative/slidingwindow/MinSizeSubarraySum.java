package com.ny.grokkingeducative.slidingwindow;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {

        int k = nums.length+1;
        int sum = 0;

        int l=0, r=0;
        //[2,3,1,2,4,3] , s = 7
        while(r < nums.length || l < nums.length) {
            //we have entered a valid window, so record the answer and then shrink the window
            if(sum >= s) {
                k = Math.min(k, r-l); //update minimum since we are in a valid window
                sum -= nums[l--]; //reduce the sum and shrink the window
            } else {//window is not valid anymore
                if(r == nums.length) break; //we have run out of elements to add
                sum += nums[r++]; //add a right elemment, expand window <-trying to make window valid again
            }
        }
        return k == nums.length+1 ? 0 : k;
    }

    public static void main(String[] args) {

        System.out.println(
                minSubArrayLen(
                        7, new int[] {
                                2,3,1,2,4,3
                        }
                )
        );

    }

}
