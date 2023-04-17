package com.ny.leetcode.contest332;

public class FindTheArrayConcatenationValue {

    public static void main(String[] args) {
        int[] ints = {5, 14, 13, 8, 12};
        int[] ints2 = {7,52,2,4};
        System.out.println(findTheArrayConcVal(ints));
        System.out.println(findTheArrayConcVal(ints2));
    }

    private static long findTheArrayConcVal(int[] nums) {

        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];

        long result = 0;

        int l = 0, r = nums.length - 1;

        while (l <= r) { //0 and 4, 1 and 3, 2 and 2
            if (l == r) {
                result += nums[l++];
            } else {
                String val = nums[l++] + "" + nums[r--];
                result += Long.parseLong(val);
            }
        }

        return result;

    }

}
