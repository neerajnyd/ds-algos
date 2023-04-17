package com.ny.leetcode.contest334;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindDivisibilityArrayOfAString {

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/java/com/ny/leetcode/contest334/input_word.txt");
        Charset charset = Charset.defaultCharset();
        String word = FileUtils.readFileToString(file, charset);
        System.out.println("Word size: " + word.length());
        int m = 1000000000;
        int[] output = divisibilityArray(word, m);


        List<Integer> expected = Arrays.stream(FileUtils.readFileToString(new File("src/main/java/com/ny/leetcode/contest334/out.txt"), charset).split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < output.length; i++) {
            if (output[i] != expected.get(i)) {
                System.out.println("Expected " + expected.get(i) + " for '" + word.substring(0, i + 1) + "' Actual: " + output[i]);
            }
        }

//        System.out.println(Arrays.toString(divisibilityArray("1", 1)));

    }
/*  Input : [48 68 43 88 56 66 66 66]
    Output: [0,1,1,0,1,0,0,0,0,1, 1, 1, 1, 1, 1, 1]
Expected:   [0,1,1,0,1,0,0,0,0,1,1,1,1,1,1,1]
     */

    public static int[] divisibilityArray(String word, int m) {

        int[] div = new int[word.length()];

        long prefix = 0;
        for (int i = 0; i < word.length(); i++) {
            prefix = (word.charAt(i) - '0') + (prefix * 10);
            prefix %= m;
            if (prefix == 0) div[i] = 1;

        }
        return div;

    }

    public static int[] divisibilityArray2(String word, int m) {

        int[] ans = new int[word.length()];
        long prefix = 0;
        for (int i = 0; i < word.length(); ++i) {
            prefix = 10 * prefix + (word.charAt(i) - '0');

            prefix %= m;
            if (prefix == 0) ans[i] = 1;
        }
        return ans;
    }
}
