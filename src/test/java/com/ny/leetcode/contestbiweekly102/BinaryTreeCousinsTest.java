package com.ny.leetcode.contestbiweekly102;

import com.ny.leetcode.domain.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeCousinsTest {

    private final BinaryTreeCousins cousins = new BinaryTreeCousins();

    @Test
    void replaceValueInTree() {

        TreeNode input = TreeNode.fromTestcase(new Integer[]{5, 4, 9, 1, 10, null, 7});
        TreeNode actual = cousins.replaceValueInTree(input);
        TreeNode expected = TreeNode.fromTestcase(new Integer[]{0, 0, 0, 7, 7, null, 11});

        Assertions.assertEquals(expected.toString(), actual.toString());

    }
}