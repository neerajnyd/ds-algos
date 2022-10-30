package com.ny.leetcode.curated.linkedlist;

import com.ny.leetcode.ListNode;

public class ReorderList {


    /*
    Input -->   L0 → L1 → … → Ln - 1 → Ln
    Output -->  L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     */
    public void reorderList(ListNode head) {
        if (head == null) return;
        /*
        1. Find the mid element
        2. Reverse the 2nd half (mid.next)
        3. Set mid.next to null (last element in new list)
        4. Intertwine the two halves
         */

        ListNode mid = findMid(head);

        ListNode head2 = reverse(mid.next);
        mid.next = null;

        intertwine(head, head2);
    }

    private void intertwine(ListNode h1, ListNode h2) {

        while (h2.next != null) {

            ListNode nextH2 = h1.next;
            h1.next = h2;
            h1 = h2;
            h2 = nextH2;
        }
    }

    private ListNode reverse(ListNode head) {

        ListNode curr = head, prev = null;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    private ListNode findMid(ListNode head) {

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }

}
