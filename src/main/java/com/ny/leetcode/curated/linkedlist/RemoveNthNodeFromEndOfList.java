package com.ny.leetcode.curated.linkedlist;

import com.ny.leetcode.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //0 -> 1->2->3->4->5 and n = 2
        //d          s     f

        ListNode dummy = new ListNode(0, head);

        ListNode left = dummy;
        ListNode right = dummy;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while(right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }

}
