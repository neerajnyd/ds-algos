package com.ny.leetcode.march2023;

import com.ny.leetcode.ArrayUtil;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class LongestCycleInGraphTest {

    private LongestCycleInGraph cycle = new LongestCycleInGraph();

    @Test
    void longestCycle() {
        int actual = cycle.longestCycle(new int[]{3, 3, 4, 2, 3});
        Assertions.assertEquals(3, actual);
        int actual2 = cycle.longestCycle(new int[]{2,-1,3,1});
        Assertions.assertEquals(-1, actual2);
    }

    @Test
    void longestCycle_Case61() {
        int actual = cycle.longestCycle(new int[]{-1, 4, -1, 2, 0, 4});
        Assertions.assertEquals(-1, actual);
    }

    @Test
    void longestCycle_Case64() throws Exception {

        File file = new File("src/test/java/com/ny/leetcode/march2023/LongestCycle_input64.txt");
        Charset charset = Charset.defaultCharset();
        String input = FileUtils.readFileToString(file, charset);

        int actual = cycle.longestCycle(ArrayUtil.read(input));

        Assertions.assertEquals(43242, actual);
    }
}