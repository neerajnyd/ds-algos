package com.ny.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));

    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums.length==1) return nums[0];
        final PriorityQueue<Integer> queue = new PriorityQueue<>(k+1);
        //we want a Min Heap

        for (Integer x : nums) {
            queue.add(x);
            if(queue.size() == k+1) {
                queue.poll();
            }
        }
        return queue.poll();

    }

}
