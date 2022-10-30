package com.ny.leetcode.curated.linkedlist;

import com.ny.leetcode.ListNode;

public class DetectCycle {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }

        }

        return false;


    }

}
