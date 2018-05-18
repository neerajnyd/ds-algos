package com.ny.datastructure;

/**
 * Singly linked list with a pointer pointing only forwards
 * TODO: refactor to work with generic types
 *
 * @author NY
 */
public class SinglyLinkedList {
	
	/*
	 * Print the Elements of a Linked List
	 */
	public void print(Node head) {
		if (head != null) {
			Node temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
	
	/*
	 * Given the head node prints the elements of a Linked List from tail to head
	 * using recursion
	 */
	public void printReverse(Node head) {
		if (head != null) {
			printReverse(head.next);
			System.out.println(head.data);
		}
	}
	
	/*
	 * Given the head node prints the elements of a Linked List from tail to head
	 * using a second list. Takes one traversal to create the new list, one other
	 * traversal to print the elements from the new list
	 */
	public void printReverseIteratively(Node head) {
		if (head != null) {
			Node newList = new Node(head.data);
			
			Node temp = head.next;
			while (newList != null && temp != null) {
				newList = insertAtHead(newList, temp.data);
				temp = temp.next;
			}
			print(newList);
		}
	}
	
	/*
	 * Insert a node at the head of a linked list. Returns head node.
	 */
	public Node insertAtHead(Node head, int x) {
		Node node = new Node(x);
		if (head != null) {
			node.next = head;
		}
		return node;
	}
	
	/*
	 * Insert a ListNode at the Tail of a Linked List. Returns head node.
	 */
	public Node insertAtEnd(Node head, int x) {
		Node node = new Node(x);
		if (head == null) {
			return node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			return head;
		}
	}
	
	/**
	 * Insert a node at a specific position in a linked list. In this
	 * implementation, it is assumed that the position position will always be
	 * between 0 and the number of the elements in the list (inclusive).
	 *
	 * @param head     The head node
	 * @param data     The new node's data
	 * @param position The position at which the new node is to be inserted. 0 for head,
	 *                 and so on.
	 * @return head
	 */
	public Node insertAtPosition(Node head, int data, int position) {
		Node newNode = new Node(data);
		if (head == null) {
			return newNode;
		}
		
		if (position == 0) {
			newNode.next = head;
			return newNode;
		}
		int i = 0;
		Node currNode = head;
		while (currNode.next != null && i < position - 1) {
			currNode = currNode.next;
			i++;
		}
		newNode.next = currNode.next;
		currNode.next = newNode;
		
		return head;
	}
	
	/**
	 * Delete a ListNode at given position in an iterative manner.
	 *
	 * @param head
	 * @param position
	 * @return head node
	 */
	public Node deleteAtPosition(Node head, int position) {
		
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
	
	/**
	 * Delete a ListNode at given position recursively. Needs O(n) space.
	 *
	 * @param head
	 * @param position
	 * @return head node
	 */
	public Node deleteAtPositionRecursively(Node head, int position) {
		
		if (position == 0) {
			return head.next;
		}
		
		head.next = deleteAtPositionRecursively(head.next, position - 1);
		
		return head;
	}
	
	public Node reverseIteratively(Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public Node reverseRecursively(Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		Node remaining = reverseRecursively(head.next);
		head.next.next = head;
		head.next = null;
		
		return remaining;
	}
	
	/*
	 * Compare two linked lists A and B Return 1 if they are identical and 0 if they
	 * are not.
	 */
	public int compare(Node headA, Node headB) {
		if (headA == null && headB == null) {
			return 1;
		}
		
		while (headA != null && headB != null) {
			if (headA.data != headB.data) {
				return 0;
			}
			headA = headA.next;
			headB = headB.next;
		}
		if (headA == null && headB == null) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/*
	 * Given two head nodes of two sorted lists, merges the two lists into one
	 * sorted list using recursion
	 */
	public Node mergeSortedRecursively(Node headA, Node headB) {
		
		if (headA == null) {
			return headB;
		}
		if (headB != null) {
			
			if (headA.data < headB.data) {
				headA.next = mergeSortedRecursively(headA.next, headB);
				return headA;
			}
			headB.next = mergeSortedRecursively(headA, headB.next);
			return headB;
		}
		
		return headA;
	}
	
	/*
	 * Given two head nodes of two sorted lists, merges the two lists into one
	 * sorted list using iteration
	 */
	public Node mergeSorted(Node currA, Node currB) {
		
		if (currA == null) {
			return currB;
		} else if (currB == null) {
			return currA;
		}

		/* Find new head pointer */
		Node head = null;
		if (currA.data < currB.data) {
			head = currA;
			currA = currA.next;
		} else {
			head = currB;
			currB = currB.next;
		}

		/* Build rest of list */
		Node n = head;
		while (currA != null && currB != null) {
			if (currA.data < currB.data) {
				n.next = currA;
				currA = currA.next;
			} else {
				n.next = currB;
				currB = currB.next;
			}
			n = n.next;
		}

		/* Attach the remaining elements */
		if (currA == null) {
			n.next = currB;
		} else {
			n.next = currA;
		}
		
		return head;
		
	}
	
	/**
	 * Simple node which works with primitive integers for now
	 *
	 * @author NY
	 */
	private static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
}
