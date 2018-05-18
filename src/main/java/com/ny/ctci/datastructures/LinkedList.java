package com.ny.ctci.datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {

	/**
	 * take a fast and a slow node. Move till slow == fast
	 * then point slow at head
	 * @param head the head ListNode
	 * @return null if fast or fast.next reaches null else the node at which the cycle exists
	 */
	public ListNode getPointOfLoop(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		
		while ((fast != null && fast.next != null) || slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast == null || fast.next == null) {
			return null;
		}
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}

	/**
	 * return the node at which two linked lists intersect
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode intersectingNode(ListNode head1, ListNode head2) {
		
		if (head1 == null || head2 == null) return null;
		
		ListNode temp1 = head1, temp2 = head2;
		
		/*
		count of nodes in each list
		 */
		int count1 = 1;
		int count2 = 1;
		while (temp1.next != null) {
			count1 += 1;
			temp1 = temp1.next;
		}
		while (temp2.next != null) {
			count2 += 1;
			temp2 = temp2.next;
		}
		/*
		if temp1 == temp2 that would mean the lists have the same end because they intersected.
		If not then they did not and we would return
		 */
		if (temp1 == temp2) {
			int absValue = Math.abs(count1 - count2);

			final ListNode intersectingNode = count1 >= count2
					? getIntersectingNode(head1, head2, absValue)
					: getIntersectingNode(head2, head1, absValue);
			return intersectingNode;
		}else{
			return null;
		}

	}

	/*
	List with head1 is "differenceInTwoLists" greater than list with head2
	So we traverse head1 differenceInTwoLists times and then move both lists together to see if the nodes are equal
	 */
	private ListNode getIntersectingNode(ListNode head1, ListNode head2, int differenceInTwoLists) {
		
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		
		for (int i = 0; i < differenceInTwoLists; i++) {
			temp1 = temp1.next;
		}
		
		while (temp1 != null) {
			if (temp1 == temp2) {
				return temp1;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		//lists did not intersect. This cannot happen because of the check in parent method.
		return null;
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		/*
		stack to store half of the list
		 */
		Stack<Integer> stack = new Stack<>();
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			stack.push(slow.val);
			slow = slow.next;
		}
		
		/*
		if fast == null then list has even no of elements
		if fast != null then list has odd number of elements
			AND we need to ignore the mid element by moving slow over
		 */
		if (fast != null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	public ListNode deleteNode(ListNode head, int d) {
		
		if (head.val == d) {
			return head.next;
		}
		
		ListNode t = head;
		
		while (t.next != null) {
			
			ListNode node = t.next;
			if (node.val == d) {
				t.next = t.next.next;
				return head;
			}
			
			t = t.next;
		}
		return head;
	}
	
	public ListNode deleteNodeAtPosition(ListNode head, int position) {
		
		if (head == null) {
			return null;
		}
		
		if (position == 0) {
			return head.next;
		}
		
		ListNode prev = head;
		for (int i = 0; i < position - 1; i++) {
			prev = prev.next;
		}
		prev.next = prev.next.next;
		return head;
		
		
	}
	
	public ListNode reverseList(ListNode head) {
		
		if (head == null || head.next == null) return head;
		
		
		ListNode prev = null;
		ListNode curr = head;
		ListNode next;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public ListNode removeDuplicates(ListNode head, boolean buffer) {
		if (!buffer) {
			return removeDuplicates(head); //if no buffer is allowed call that method
		}
		
		if (head == null || head.next == null) return head;
		
		Set<Integer> set = new HashSet<>();
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			
			if (set.contains(curr.val)) {
				prev.next = curr.next;
			} else {
				set.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}
		
		return head;
	}
	
	public ListNode removeDuplicates(ListNode head) {
		
		ListNode curr = head;
		
		while (curr != null) {
			ListNode runner = curr;
			while (runner.next != null) {
				if (runner.next.val == curr.val) {
					runner.next = runner.next.next;
				}
				runner = runner.next;
			}
			curr = curr.next;
		}
		return head;
	}
	
	/**
	 * when the list size is known just get the (n-l)th element
	 * otherwise use two nodes, k length apart to reach the last kth element
	 *
	 * @param head the head of the list
	 * @return kth element
	 */
	public ListNode kThToLastNode(ListNode head, int k) {
		
		ListNode p1 = head;
		ListNode p2 = head;
		int count = 0;
		while (p1 != null && count != k) {
			p1 = p1.next;
			count++;
		}
		while (p1 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p2;
		
	}
	
	public ListNode removeMidNode(ListNode head, ListNode c) {
		
		ListNode prev = head;
		ListNode curr = head;
		
		while (curr != null && curr != c) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		
		return head;
	}
	
	/**
	 * remove c when head isn't provided. c must not be the last node
	 *
	 * @param c
	 * @return
	 */
	public boolean removeMidNode(ListNode c) {
		if (c == null || c.next == null) {
			return false; //failure scenario
		}
		
		ListNode temp = c.next;
		c.val = temp.val;
		c.next = temp.next;
		return true;
	}
	
	public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
		
		ListNode dummy = new ListNode(0);
		ListNode p1 = n1, p2 = n2, curr = dummy;
		int carry = 0;
		while (p1 != null || p2 != null) {
			int x = p1 != null ? p1.val : 0;
			int y = p2 != null ? p2.val : 0;
			
			if (p1 != null) p1 = p1.next;
			if (p2 != null) p2 = p2.next;
			
			int sum = x + y + carry;
			carry = sum / 10;
			sum %= 10;
			ListNode node = new ListNode(sum);
			curr.next = node;
			
			curr = curr.next;
		}
		
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummy.next;
		
	}
	
	
}
