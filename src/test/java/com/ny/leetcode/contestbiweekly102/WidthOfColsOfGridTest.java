package com.ny.leetcode.contestbiweekly102;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WidthOfColsOfGridTest {

    @Test
    void findColumnWidth() {

        WidthOfColsOfGrid s = new WidthOfColsOfGrid();
        Assertions.assertEquals("[3]", Arrays.toString(s.findColumnWidth(ArrayUtil.read2D("[[1],[22],[333]]"))));

    }
}