package com.ny.leetcode.contest336;

import java.util.Arrays;
import java.util.Comparator;

public class RearrangeMaximizePrefixScore {

    public static void main(String[] args) {
        RearrangeMaximizePrefixScore score = new RearrangeMaximizePrefixScore();
        System.out.println(score.maxScore(new int[]{-687767, -860350, 950296, 52109, 510127, 545329, -291223, -966728, 852403, 828596, 456730, -483632, -529386, 356766, 147293, 572374, 243605, 931468, 641668, 494446}));
    }

    public int maxScore(int[] nums) {

        Arrays.sort(nums);
        int c = 0;
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if(sum > 0) c++;
        }
        return c;
    }

}
