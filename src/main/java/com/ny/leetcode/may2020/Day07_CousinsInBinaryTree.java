package com.ny.leetcode.may2020;

import com.ny.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Day07_CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> Q = new LinkedList<>();

        Q.offer(root);
        /*
                1
               /\           x=4, y =3
              2  3
             /
            4
        */
        int dx = -1, dy = -1;
        int d = -1;
        while(!Q.isEmpty()) { // 4
            int n = Q.size(); //2
            d++; //1
            for(int i=0; i<n; i++) {
                TreeNode node = Q.poll();
                int val = node.val;//4
                TreeNode left = node.left; //null
                TreeNode right = node.right; //null

                //x and y are equal to left and right (or vice-versa)
                if((same(left, x) || same(right, x)) && (same(left, y) || same(right, y)))
                    return false;

                if(val == x) dx = d; //4 == 4 dy = 2
                else if(val == y) dy = d; //3 == 3 dy = 1

                if(left != null) Q.offer(left);
                if(right != null) Q.offer(right);
            }
            if(dx != -1 && dy != -1 && dx == dy) return true;
        }
        return dx != -1 && dy != -1 && dx == dy;
    }

    private boolean same(TreeNode node, int val) {
        if(node == null) return false;
        return val == node.val;
    }
}
