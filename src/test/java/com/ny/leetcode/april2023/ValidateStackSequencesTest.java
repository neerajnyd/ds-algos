package com.ny.leetcode.april2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateStackSequencesTest {

    private final ValidateStackSequences v = new ValidateStackSequences();

    @Test
    void validateStackSequences_case1() {

        boolean actual = v.validateStackSequences(ArrayUtil.read("[1,2,3,4,5]"), ArrayUtil.read("[4,5,3,2,1]"));
        Assertions.assertTrue(actual);
    }

     @Test
    void validateStackSequences_case2() {

        boolean actual = v.validateStackSequences(ArrayUtil.read("[1,2,3,4,5]"), ArrayUtil.read("[4,3,5,1,2]"));
        Assertions.assertFalse(actual);
    }


}