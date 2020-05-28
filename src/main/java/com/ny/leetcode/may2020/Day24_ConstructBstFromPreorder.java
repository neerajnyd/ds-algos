package com.ny.leetcode.may2020;

import com.ny.leetcode.domain.TreeNode;

public class Day24_ConstructBstFromPreorder {

    public static void main(String[] args) {
        int[] preOrder = {4,2};
        System.out.println(bstFromPreorder(preOrder));
    }


    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstPreOrderHelper(preorder, 0, preorder.length);
    }

    private static TreeNode bstPreOrderHelper(int[] preorder, int nodePos, int lastChildPos) {

        if(nodePos >= lastChildPos) return null;

        int firstRightChildPos = nodePos+1;
        while (firstRightChildPos < lastChildPos && preorder[firstRightChildPos] < preorder[nodePos])
            ++firstRightChildPos;

        return new TreeNode(
                preorder[nodePos],
                bstPreOrderHelper(preorder, nodePos+1, firstRightChildPos),
                bstPreOrderHelper(preorder, firstRightChildPos, lastChildPos)
        );
    }


}
