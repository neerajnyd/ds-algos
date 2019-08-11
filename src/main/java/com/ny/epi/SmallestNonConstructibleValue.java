package com.ny.epi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestNonConstructibleValue {

    public static void main(String[] args) {

        final List<Integer> a = Arrays.asList(12, 2,1,15, 2, 4);

        int result = method(a);

        System.out.println(result);

    }

    private static int method(List<Integer> values) {
        Collections.sort(values);
        Integer maxConstructibleValue = 0; //possible change at the beginning is zero
        for (Integer a : values) {
            if(maxConstructibleValue+1 < a) { //if a is bigger than (max possible + 1) then return (max possible + 1)
                break;
            } else {
                maxConstructibleValue += a; //otherwise add to (max possible) and try with next number
            }
        }
        return maxConstructibleValue+1;

    }

}
