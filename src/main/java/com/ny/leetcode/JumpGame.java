package com.ny.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{
                3,3,1,0,4
        }));
    }

    public static boolean canJump(int[] A) {
        int leftMostGoodPos = A.length - 1;
        for (int currPos = A.length - 1; currPos >= 0; currPos--) {
            int jumpFromCurrPos = A[currPos];
            int maxReachablePos = currPos + jumpFromCurrPos;
            if (maxReachablePos >= leftMostGoodPos)
                leftMostGoodPos = currPos;
        }
        return leftMostGoodPos == 0;
    }

    public static boolean canJump3(int[] A) {

        Set<Integer> set = new HashSet<>();
        set.add(A.length - 1);

        for (int i = A.length - 2; i >= 0; i--) {
            int maxJump = Math.min(i + A[i], A.length - 1);
            for (int j = maxJump; j >= i+1; j--) {
                if (set.contains(j)) {
                    set.add(i);
                    break;
                }
            }
        }
        return set.contains(0);

    }

    public static boolean canJump2(int[] A) {
        return canJump2Helper(A, 0, new HashMap<>());
    }

    private static boolean canJump2Helper(int[] nums, int position, Map<Integer, Boolean> map) {
        final int n = nums.length - 1;
        if(position == n) return true;
        if(position > n) return false;

        if (map.containsKey(position))
            return map.get(position);

        int furthestJump = Math.min(position + nums[position], n);

        for (int jump = 1; jump <= furthestJump; jump++) {
            if(canJump2Helper(nums, position+jump, map)) {
                map.put(position, true);
                return true;
            }
        }
        map.put(position, false);
        return false;
    }

}
