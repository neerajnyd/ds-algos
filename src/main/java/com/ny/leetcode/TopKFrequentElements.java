package com.ny.leetcode;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        List<Integer> elements = topKFrequent(nums, 2);
        System.out.println(elements);

    }

    private static List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(Integer i : nums) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        final List<Integer>[] bucket = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer number = entry.getKey();
            Integer frequency = entry.getValue();

            if(bucket[frequency] == null) {
                bucket[frequency] = new LinkedList<>();
            }
            bucket[frequency].add(number);
        }

        final List<Integer> result = new ArrayList<>();
        for (int i = bucket.length-1; i > 0 && k > 0 ; i--) {
            if(bucket[i] != null) {
                List<Integer> list = bucket[i];
                result.addAll(list);
                k -= list.size();
            }
        }
        return result;
    }

}
