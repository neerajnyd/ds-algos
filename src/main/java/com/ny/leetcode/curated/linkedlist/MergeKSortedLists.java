package com.ny.leetcode.curated.linkedlist;

import com.ny.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class RecursiveMergeSortMerge {

        public ListNode mergeKLists(ListNode[] lists) {

            if (lists == null || lists.length == 0) return null;

            return mergeKLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeKLists(ListNode[] lists, int start, int end) {

            if (start == end) return lists[start];
            if (start > end) return null;

            int mid = (end - start) / 2 + start;

            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode dummy = new ListNode(0);
            ListNode iter = dummy;

            while (l1 != null && l2 != null) {

                if (l1.val < l2.val) {
                    iter.next = l1;
                    l1 = l1.next;
                } else {
                    iter.next = l2;
                    l2 = l2.next;
                }
                iter = iter.next;

            }

            iter.next = l1 != null ? l1 : l2;

            return dummy.next;
        }
    }

    public static class PriorityQueueMerge {

        public ListNode mergeKLists(ListNode[] lists) {

            if (lists == null || lists.length == 0) return null;

            PriorityQueue<ListNode> Q = createPopulatedPriorityQueue(lists);

            ListNode dummy = new ListNode(0);
            ListNode head = dummy;

            while (!Q.isEmpty()) {

                ListNode node = Q.poll();
                head.next = node; //supposing lists has no null nodes
                node = node.next;
                if (node != null) {
                    Q.offer(node);
                }
                head = head.next;

            }

            return dummy.next;
        }

        private PriorityQueue<ListNode> createPopulatedPriorityQueue(ListNode[] lists) {
            PriorityQueue<ListNode> Q = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

            for (ListNode l : lists) {
                if (l != null) {
                    Q.offer(l);
                }
            }
            return Q;
        }

    }


}
