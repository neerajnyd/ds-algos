package com.ny.leetcode.curatedlistchallenge.day2;

public class JumpGame {

    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }

    private boolean jump(int[] nums, int i) {
        // 3,2,1,0,4
        // i=0
        if(i == nums.length-1) return true;
        if(i >= nums.length) return false;

        int maxJump = nums[i];

        for(int j=1; j<=maxJump; j++) {
            boolean b = jump(nums, i+j);
            if(b) return true;
        }
        return false;
    }

    public boolean canJump2(int[] A) {
        int leftMostGoodPos = A.length - 1;
        for (int currPos = A.length - 1; currPos >= 0; currPos--) {
            int jumpFromCurrPos = A[currPos];
            int maxReachablePos = currPos + jumpFromCurrPos;
            if (maxReachablePos >= leftMostGoodPos)
                leftMostGoodPos = currPos;
        }
        return leftMostGoodPos == 0;
    }

}
