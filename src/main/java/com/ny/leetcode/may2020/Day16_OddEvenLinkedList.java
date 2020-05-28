package com.ny.leetcode.may2020;

import com.ny.leetcode.ListNode;

public class Day16_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = even;

        while(even != null && even.next != null) {

            ListNode nextOdd = even.next;
            odd.next = nextOdd;

            ListNode nextEven = nextOdd.next;
            even.next = nextEven;

            odd = nextOdd;
            even = nextEven;
        }
        odd.next = firstEven;
        return head;
    }

}
