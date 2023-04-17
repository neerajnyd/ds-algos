package com.ny.leetcode.contest341;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumAdditionsToMakeValidStringTest {

    private final MinimumAdditionsToMakeValidString str = new MinimumAdditionsToMakeValidString();

    @Test
    void addMinimum() {

        int actual = str.addMinimum("b");
        Assertions.assertEquals(2, actual);
    }

    @Test
    void addMinimum_case2() {

        int actual = str.addMinimum("aaa");
        Assertions.assertEquals(6, actual);
    }

    @Test
    void addMinimum_case3() {

        int actual = str.addMinimum("abc");
        Assertions.assertEquals(0, actual);
    }

    @Test
    void addMinimum_case4() {

        int actual = str.addMinimum("aaaabb");
        Assertions.assertEquals(9, actual);
    }

    @Test
    void addMinimum_case5() {

        int actual = str.addMinimum("aaaacb");
        Assertions.assertEquals(9, actual);
    }
}