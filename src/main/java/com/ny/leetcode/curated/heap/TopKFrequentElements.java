package com.ny.leetcode.curated.heap;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 3, 3, 1, 2, 2, 3};

        int[] elements = topKFrequent_MaxHeap(nums, 2);
        int[] elements2 = topKFrequent_MinHeap(nums, 3);
        System.out.println(Arrays.toString(elements));
        System.out.println(Arrays.toString(elements2));

    }

    private static int[] topKFrequent_MinHeap(int[] nums, int k) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (Integer num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.length, Comparator.comparingInt(n -> count.getOrDefault(n, 0)));
        minHeap.addAll(count.keySet());

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); //so minHeap size can be reduced and insertion time improves
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            if (minHeap.isEmpty()) break;
            result[i] = minHeap.poll();
        }
        return result;
    }

    private static int[] topKFrequent_MaxHeap(int[] nums, int k) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (Integer num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        /* {
            1 -> 3
            2 -> 2
            3 -> 1
         }*/
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                nums.length,
                (n1, n2) -> count.getOrDefault(n2, 0) - count.getOrDefault(n1, 0)
        );
        heap.addAll(count.keySet());
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            if (heap.isEmpty()) break;
            result[i] = heap.poll();
        }
        return result;
    }

}
