package com.ny.leetcode;

/**
 *  Given 2 numbers using 2 lists with each digit a node,
 *  return a new LL head node which represents their sum
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode one = new ListNode(2);
		ListNode two = new ListNode(4);
		ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		
		ListNode four = new ListNode(5);
		ListNode five = new ListNode(6);
		ListNode six = new ListNode(4);
		four.next = five;
		five.next = six;
		
		ListNode temp = officialIterative(one, four);
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
	}
	
	private static ListNode officialIterative(ListNode n1, ListNode n2) {
		
		ListNode dummyHead = new ListNode(0);
		ListNode p = n1, q = n2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			
			if (p != null) p = p.next;
			if (q != null) q = q.next;
			
			int sum = x + y + carry;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
	
	private static ListNode unOfficialRecursive(ListNode node1, ListNode node2) {
		if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		} else {
			int val = (node1.val + node2.val) >= 10 ?
							(node1.val + node2.val - 10) :
							(node1.val + node2.val);
			
			ListNode result = new ListNode(val);
			result.next = unOfficialRecursive(node1.next, node2.next);
			if (node1.val + node2.val >= 10) {
				result.next = unOfficialRecursive(result.next, new ListNode(1));
			}
			return result;
		}
	}
	
	private static ListNode bruteForce(ListNode n1, ListNode n2) {
		
		int addValue = n1.val + n2.val;
		int remainder = addValue % 10;
		ListNode node = new ListNode(remainder);
		int quotient = addValue / 10;
		
		ListNode n12 = n1.next;
		ListNode n22 = n2.next;
		int addValue2 = n12.val + n22.val + quotient;
		int remainder2 = addValue2 % 10;
		ListNode node2 = new ListNode(remainder2);
		node.next = node2;
		int quotient2 = addValue2 / 10;
		
		ListNode n13 = n12.next;
		ListNode n23 = n22.next;
		int addValue3 = n13.val + n23.val + quotient2;
		int remainder3 = addValue3 % 10;
		ListNode node3 = new ListNode(remainder3);
		node2.next = node3;
		int quotient3 = addValue3 / 10;
		
		if (quotient3 == 1) {
			node3.next = new ListNode(quotient3);
		}
		return node;
	}
	
}
