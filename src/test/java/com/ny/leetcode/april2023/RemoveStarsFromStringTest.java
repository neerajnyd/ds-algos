package com.ny.leetcode.april2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveStarsFromStringTest {

    RemoveStarsFromString s = new RemoveStarsFromString();

    @Test
    void removeStars_case1() {

        String actual = s.removeStars("leet**cod*e");
        Assertions.assertEquals("lecoe", actual);

    }

    @Test
    void removeStars_case2() {

        String actual = s.removeStars("erase*****");
        Assertions.assertEquals("", actual);

    }


}