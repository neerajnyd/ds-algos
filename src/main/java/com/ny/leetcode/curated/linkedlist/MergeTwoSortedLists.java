package com.ny.leetcode.curated.linkedlist;

import com.ny.leetcode.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;

        }

        head.next = list1 != null ? list1 : list2;

        return dummy.next;

    }

}
