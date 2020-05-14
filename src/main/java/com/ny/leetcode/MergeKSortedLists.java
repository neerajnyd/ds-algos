package com.ny.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;

        PriorityQueue<ListNode> Q = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));

        for(ListNode node : lists) if(node != null) Q.offer(node);

        ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;

        while (!Q.isEmpty()) {
            iter.next = Q.poll();
            iter = iter.next;

            if(iter.next != null) Q.offer(iter.next);
        }
        return dummy.next;
    }


}
