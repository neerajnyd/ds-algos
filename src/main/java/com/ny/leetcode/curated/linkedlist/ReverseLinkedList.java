package com.ny.leetcode.curated.linkedlist;

import com.ny.leetcode.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        //[1 -> 2 -> 3 -> 4 -> 5]
        if(head == null || head.next == null) return head;

        ListNode curr = head, prev = null;

        while(curr != null) {

            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        return prev;
    }

}
