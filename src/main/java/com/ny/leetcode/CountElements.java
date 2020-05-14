package com.ny.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountElements {

    public static int countElements(int[] A) {
        int c = 0;
        Set<Integer> nums = new HashSet<>();
        for (int i : A) nums.add(i);
        for (int a : A) if (nums.contains(a + 1)) c++;
        return c;
    }

    public static void main(String[] args) {
        int[] A = {1,1,2,2};
        System.out.println(countElements(A));
    }
    /*
    Input: arr = [1,2,3]
    Output: 2
    Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

    Input: arr = [1,1,3,3,5,5,7,7]
    Output: 0
    Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

    Input: arr = [1,3,2,3,5,0]
    Output: 3
    Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.

    Input: arr = [1,1,2,2]
    Output: 2
    Explanation: Two 1s are counted cause 2 is in arr.
     */

}
