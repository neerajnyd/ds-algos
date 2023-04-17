package com.ny.leetcode.march2023;

import com.ny.leetcode.domain.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CheckCompleteness {

    public static void main(String[] args) {

        CheckCompleteness c = new CheckCompleteness();

        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8,
                                        new TreeNode(15), null
                                ),
                                new TreeNode(9)
                        ),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11)
                        )
                ),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12),
                                new TreeNode(13)),
                        new TreeNode(7)
                )
        );
        System.out.println(c.isCompleteTree(node));

    }


    /*
    every level is completely filled
        OR
        it's the last level AND all nodes are left aligned
     */
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        boolean emptyFound = false;

        while (!Q.isEmpty()) {

            TreeNode curr = Q.poll();
            if (curr == null) {
                emptyFound = true;
                continue;
            } else if (emptyFound) return false;

            Q.offer(curr.left);
            Q.offer(curr.right);

        }
        return true;
    }


}
