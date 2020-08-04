package com.ny.grokkingeducative.twopointers;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {
                0,0,1,1,1,2,2,3,3,4
        }));
    }

    //return the count of unique elements actually
    private static int removeDuplicates(int[] nums) {
        int i = 1; //i tracks unique numbers, 1 is the default for non empty nums array
        int a = nums[0]; //keeps the last unique number
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != a) { //unique number found
                a = nums[j];//update unique number
                i++;//update count of unique elements
            }
        }
        return i;
    }

}
