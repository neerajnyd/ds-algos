package com.ny.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersection = intersect(nums1, nums2);

        for (int x : intersection) {
            System.out.print(x + " ");
        }
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        final int l1 = nums1.length;
        final int l2 = nums2.length;
        if(l1 == 0 || l2 == 0) return new int[]{};
        final Map<Integer, Integer> map1 = new HashMap<>();
        final Map<Integer, Integer> map2 = new HashMap<>();

        for(int n : nums1) {
            map1.put(n, map1.getOrDefault(n,0) + 1);
        }
        for(int n : nums2) {
            map2.put(n, map2.getOrDefault(n,0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            if(map2.containsKey(entry1.getKey())) {
                int c1 = entry1.getValue();
                int c2 = map2.get(entry1.getKey());
                int count = Math.min(c1, c2);
                for(int i=0; i<count; i++) {
                    list.add(entry1.getKey());
                }
            }
        }
        int[] A = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            A[i] = list.get(i);
        }
        return A;

    }

}
