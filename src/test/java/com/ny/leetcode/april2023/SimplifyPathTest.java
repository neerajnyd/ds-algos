package com.ny.leetcode.april2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifyPathTest {

    private final SimplifyPath p = new SimplifyPath();

    @Test
    void simplifyPath_case1() {

        String actual = p.simplifyPath("/home/");
        Assertions.assertEquals("/home", actual);
    }

    @Test
    void simplifyPath_case2() {

        String actual = p.simplifyPath("/../");
        Assertions.assertEquals("/", actual);
    }

    @Test
    void simplifyPath_case3() {

        String actual = p.simplifyPath("/home//home2");
        Assertions.assertEquals("/home/home2", actual);
    }

    @Test
    void simplifyPath_case4() {

        String actual = p.simplifyPath("/home/home2/../");
        Assertions.assertEquals("/home", actual);
    }

    @Test
    void simplifyPath_case5() {

        String actual = p.simplifyPath("/home/home2/../../");
        Assertions.assertEquals("/", actual);
    }

    @Test
    void simplifyPath_case6() {

        String actual = p.simplifyPath("/a/./b/../../c/");
        Assertions.assertEquals("/c", actual);
    }

    @Test
    void simplifyPath_case7() {

        String actual = p.simplifyPath("/a//b////c/d//././/..");
        Assertions.assertEquals("/a/b/c", actual);
    }

    @Test
    void simplifyPath_case8() {

        String actual = p.simplifyPath("/.");
        Assertions.assertEquals("/", actual);
    }

    @Test
    void simplifyPath_case9() {

        String actual = p.simplifyPath("/./");
        Assertions.assertEquals("/", actual);
    }

    @Test
    void simplifyPath_case10() {

        String actual = p.simplifyPath("/hello../world");
        Assertions.assertEquals("/hello../world", actual);
    }

    @Test
    void simplifyPath_case11() {

        String actual = p.simplifyPath("/hello./world/");
        Assertions.assertEquals("/hello./world", actual);
    }

    @Test
    void simplifyPath_case12() {

        String path = "/home/of/foo/../../bar/../../is/./here/.";
//      /is/here/.
        String actual = p.simplifyPath(path);
        Assertions.assertEquals("/is/here", actual);
    }


}