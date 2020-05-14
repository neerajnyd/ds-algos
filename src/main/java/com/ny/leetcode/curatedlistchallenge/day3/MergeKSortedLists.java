package com.ny.leetcode.curatedlistchallenge.day2;

import com.ny.leetcode.ListNode;

import java.util.*;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] nodes) {
        if (nodes == null) return null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> Q = new PriorityQueue<>(Comparator.comparingInt((ListNode n) -> n.val));

        for (ListNode listNode : nodes) if (listNode != null) Q.add(listNode);

        while (!Q.isEmpty()) {
            ListNode node = Q.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) Q.add(node.next);
        }
        return dummy.next;
    }

    //BRUTE-FORCE
    public ListNode mergeKLists_Brute(ListNode[] lists) {
        List<Integer> l = new ArrayList<Integer>();

        for (ListNode ln : lists)
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }

        Collections.sort(l);

        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int i : l) {
            ListNode t = new ListNode(i);
            h.next = t;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }

    /*
    Compare every \text{k}k nodes (head of every linked list) and get the node with the smallest value.
     */
    public ListNode mergeKLists_OneByOneConstantSpace(ListNode[] lists) {
        int min_index = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++)
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min_index = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }
            if (isBreak) break;
            h.next = lists[min_index];
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }
        h.next = null;
        return head.next;
    }

    /*
    Convert merge k lists problem to merge 2 lists k-1 times
     */
    public ListNode mergeKLists_UsingTwoListsMerge(ListNode[] lists) {
        if (lists.length == 1) return lists[0];
        if (lists.length == 0) return null;
        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) head = mergeTwoLists(head, lists[i]);
        return head;
    }

    /*
    Approach 5: Merge with Divide And Conquer
    */
    public ListNode mergeKLists_DnQ(ListNode[] lists) {
        if (lists.length == 0) return null;
        int interval = 1;
        while (interval < lists.length) {
            System.out.println(lists.length);
            for (int i = 0; i + interval < lists.length; i = i + interval * 2)
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            interval *= 2;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null) if (l1.val < l2.val) {
            h.next = l1;
            h = h.next;
            l1 = l1.next;
        } else {
            h.next = l2;
            h = h.next;
            l2 = l2.next;
        }
        if (l1 == null) h.next = l2;
        if (l2 == null) h.next = l1;
        return ans.next;
    }
}
