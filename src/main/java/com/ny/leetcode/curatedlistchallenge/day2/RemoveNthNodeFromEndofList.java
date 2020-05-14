package com.ny.leetcode.curatedlistchallenge.day2;

import com.ny.leetcode.ListNode;

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //0 -> 1->2->3->4->5 and n = 2
        //d          s     f

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        while(n > 0) {
            fast = fast.next;
            n--;
        }

        ListNode slow = dummy;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

}
