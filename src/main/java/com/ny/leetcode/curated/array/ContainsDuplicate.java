package com.ny.leetcode.curated.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1};

        System.out.println(
                containsDuplicate(A)
        );
    }

    private static boolean containsDuplicate(int[] nums) {

        //using a set means that we iterate over an array and also iterate over the set for contains operation (a constant time operation)
        //sorting and then comparing adjacent numbers would lead to n(logn) implementation


        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;

    }

}
