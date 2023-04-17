package com.ny.leetcode.april2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnclaveCountTest {

    private final EnclaveCount c = new EnclaveCount();

    @Test
    void numEnclaves_case1() {
        int actual = c.numEnclaves(ArrayUtil.read2D("[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]"));
        Assertions.assertEquals(3, actual);
    }

    @Test
    void numEnclaves_case2() {
        int actual = c.numEnclaves(ArrayUtil.read2D("[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]"));
        Assertions.assertEquals(0, actual);
    }


}