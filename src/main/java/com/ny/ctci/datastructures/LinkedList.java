package com.ny.ctci.datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {
	
	public Node getPointOfLoop(Node head) {
		
		Node slow = head;
		Node fast = head;
		
		while ((fast != null && fast.next != null) || slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast == null && fast.next == null) {
			return null;
		}
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public Node intersectingNode(Node n1, Node n2) {
		
		if (n1 == null || n2 == null) return null;
		
		Node t1 = n1, t2 = n2;
		
		int count1 = 1;
		int count2 = 1;
		while (t1.next != null) {
			count1 += 1;
			t1 = t1.next;
		}
		while (t2.next != null) {
			count2 += 1;
			t2 = t2.next;
		}
		/*
		if t1 == t2 that would mean the lists intersected.
		If not then they did not and we would return
		 */
		if (t1 != t2) {
			return null;
		}
		Node intersectingNode;
		int absValue = Math.abs(count1 - count2);
		if (count1 >= count2) {
			intersectingNode = getIntersectingNode(n1, n2, absValue);
		} else {
			intersectingNode = getIntersectingNode(n2, n1, absValue);
		}
		
		return intersectingNode;
	}
	
	private Node getIntersectingNode(Node n1, Node n2, int count) {
		
		Node t1 = n1;
		Node t2 = n2;
		
		for (int i = 0; i < count; i++) {
			t1 = t1.next;
			
		}
		
		while (t1 != null) {
			
			if (t1 == t2) {
				return t1;
			}
			
			t1 = t1.next;
			t2 = t2.next;
		}
		
		return null;
	}
	
	public boolean isPalindrome(Node head) {
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<>();
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			stack.push(slow.val);
			slow = slow.next;
		}
		
		/*
		if list has odd number of elements then we need to ignore the mid element
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
	
	public Node deleteNode(Node head, int d) {
		
		if (head.val == d) {
			return head.next;
		}
		
		Node t = head;
		
		while (t.next != null) {
			
			Node node = t.next;
			if (node.val == d) {
				t.next = t.next.next;
				return head;
			}
			
			t = t.next;
		}
		return head;
	}
	
	public Node deleteNodeAtPosition(Node head, int position) {
		
		if (head == null) {
			return null;
		}
		
		if (position == 0) {
			return head.next;
		}
		
		Node prev = head;
		for (int i = 0; i < position - 1; i++) {
			prev = prev.next;
		}
		prev.next = prev.next.next;
		return head;
		
		
	}
	
	public Node reverseList(Node head) {
		
		if (head == null || head.next == null) return head;
		
		
		Node prev = null;
		Node curr = head;
		Node next;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public Node removeDuplicates(Node head, boolean buffer) {
		if (!buffer) {
			return removeDuplicates(head); //if no buffer is allowed call that method
		}
		
		if (head == null || head.next == null) return head;
		
		Set<Integer> set = new HashSet<>();
		Node prev = null;
		Node curr = head;
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
	
	public Node removeDuplicates(Node head) {
		
		Node curr = head;
		
		while (curr != null) {
			Node runner = curr;
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
	public Node kThToLastNode(Node head, int k) {
		
		Node p1 = head;
		Node p2 = head;
		int count = 0;
		while (p1 != null && count == k) {
			p1 = p1.next;
			count++;
		}
		while (p1 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p2;
		
	}
	
	public Node removeMidNode(Node head, Node c) {
		
		Node prev = head;
		Node curr = head;
		
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
	public boolean removeMidNode(Node c) {
		if (c == null || c.next == null) {
			return false; //failure scenario
		}
		
		Node temp = c.next;
		c.val = temp.val;
		c.next = temp.next;
		return true;
	}
	
	public Node addTwoNumbers(Node n1, Node n2) {
		
		Node dummy = new Node(0);
		Node p1 = n1, p2 = n2, curr = dummy;
		int carry = 0;
		while (p1 != null || p2 != null) {
			int x = p1 != null ? p1.val : 0;
			int y = p2 != null ? p2.val : 0;
			
			if (p1 != null) p1 = p1.next;
			if (p2 != null) p2 = p2.next;
			
			int sum = x + y + carry;
			carry = sum / 10;
			sum %= 10;
			Node node = new Node(sum);
			curr.next = node;
			
			curr = curr.next;
		}
		
		if (carry > 0) {
			curr.next = new Node(carry);
		}
		return dummy.next;
		
	}
	
	
}
