package com.ny.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeLists {
	
	public static void main(String[] args) {
	
	}

	public static ListNode mergekSortedListsUsingPriorityQueue(ListNode[] lists) {
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
	
	
	public static ListNode mergeLists(ListNode n1, ListNode n2) {
		
		ListNode t1 = n1;
		ListNode t2 = n2;
		
		ListNode n = new ListNode(0); //dummy node
		ListNode nCopy = n;
		while (t1 != null && t2 != null) {
			
			if (t1.val <= t2.val) {
				n.next = t1;
				t1 = t1.next;
			} else {
				n.next = t2;
				t2 = t2.next;
			}
			n = n.next;
			
		}
		if (t1 == null && t2 != null) {
			n.next = t2;
		} else if (t1 != null) {
			n.next = t1;
		}
		
		return nCopy.next;
	}
	
	public static ListNode mergeListsRecursively(ListNode node1, ListNode node2) {
		
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}
		
		if (node1.val > node2.val) {
			node2.next = mergeListsRecursively(node1, node2.next);
			return node2;
		}
		node1.next = mergeListsRecursively(node1.next, node2);
		return node1;
	}
	
}
