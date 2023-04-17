package com.ny.leetcode.lc75;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));

    }

    private static int longestPalindrome(String s) {
        //there should be at most 1 character that has odd count

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        boolean hasOdd = false;
        int result = 0;
        for (Integer count : map.values()) {
            if (count % 2 == 0) {
                result += count;
            } else {
                result += count - 1;
                hasOdd = true;
            }
        }
        return result + (hasOdd ? 1 : 0);
    }

}
