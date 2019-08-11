package com.ny.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        int n = 15;

        List<String> fizzBuzz = fizzBuzz(n);

        for (String s : fizzBuzz) {
            System.out.println(s);
        }
    }

    public static List<String> fizzBuzz(int n) {
        final List<String> R = new ArrayList<>();
        for (int number = 1; number <= n; number++) {
            if (number % 3 == 0) {
                if (number % 5 == 0) {
                    R.add("FizzBuzz");
                } else {
                    R.add("Fizz");
                }
            } else if (number % 5 == 0) {
                R.add("Buzz");
            } else {
                R.add(String.valueOf(number));
            }
        }
        return R;
    }

}
