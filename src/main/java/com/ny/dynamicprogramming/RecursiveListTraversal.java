package com.ny.dynamicprogramming;

import com.ny.model.ListNode;

public class RecursiveListTraversal {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = one;
        one.next = two;
        two.next = three;

        preOrder(head);
        System.out.println("---");
        postOrder(head);


    }

    private static void preOrder(ListNode head) {
        if (head != null) {
            System.out.println(head.data);
            preOrder(head.next);
        }
    }

    private static void postOrder(ListNode head) {
        if (head != null) {
            postOrder(head.next);
            System.out.println(head.data);
        }
    }

}
