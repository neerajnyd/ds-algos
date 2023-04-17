package com.ny.leetcode.contestbiweekly98;

import com.ny.leetcode.ArrayUtil;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithMaxCost {

    public static void main(String[] args) {
        SubstringWithMaxCost cost = new SubstringWithMaxCost();
        /*
        "talaqlt"
"tqla"
[4,3,3,-2]
         */
        System.out.println(cost.maximumCostSubstring("talaqlt", "tqla", ArrayUtil.read("[4,3,3,-2]")));

    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {

        Map<Character, Integer> costs = getCosts(chars, vals);

        int maxSum = 0;
        int runningSum = 0;

        for (char c : s.toCharArray()) {
            int num = costs.getOrDefault(c, aToi(c));
            runningSum = Math.max(num, num + runningSum);
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }

    private Map<Character, Integer> getCosts(String chars, int[] vals) {
        Map<Character, Integer> costs = new HashMap<>();
        char[] charArray = chars.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char x = charArray[i];
            int c = vals[i];
            costs.put(x, c);
        }
        return costs;
    }

    private int aToi(char x) {
        return x - 'a' + 1;
    }

}
