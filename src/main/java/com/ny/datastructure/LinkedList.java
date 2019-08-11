package com.ny.datastructure;

public class LinkedList {

    /*
    take a slow and a fast pointer. return the node at the slow pointer.
     */
    public Node findMidElement(Node head) {

        if (head == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node reverseLinkedList(Node L) {
        Node sublistHead = null, subListIter = L;
        while (subListIter != null) {
            Node temp = subListIter.next;
            subListIter.next = sublistHead;
            sublistHead = subListIter;
            subListIter = temp;
        }
        return sublistHead;
    }

    public Node reverseLinkedListWithDummy(Node L) {
        Node dummy = new Node(0);
        dummy.next = L;
        Node subListHead = dummy;
        int k = 1;
        while(k++ < 0) {

        }
        Node previousNode = null, currentNode = L, nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return dummy.next;
    }

    public void printReverse(Node head) {
        if (head == null) {
            return;
        }

        printReverse(head.next);
        System.out.print(head.value + " ");
    }

    public Node returnKthFromEnd(Node head, int k) {
        Node fast = head;
        Node slow = head;

        int i = 0;
        while (fast != null || i != k) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /*
    recursive solution
     */
    public Node mergeTwoLists(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.value < head2.value) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }

    /*
    iterative solution
     */
    public Node mergeTwoLists2(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node prev = dummy;

        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }

        if (head1 == null)
            prev.next = head2;
        if (head2 == null)
            prev.next = head1;
        return dummy.next;
    }

    public RandomNode randomNodeCopy(RandomNode head){
        RandomNode iter = head, next;

        while(iter != null){
            next = iter.next; //save the next node
            RandomNode copy = new RandomNode(iter.value);
            iter.next = copy; //update node to point to new copy node
            copy.next = next; //update copy node to point to the original next node
            iter = next; // update node to next for iteration
        }

        iter = head;
        while(iter != null){
            if(iter.random != null){
                RandomNode copy = iter.next;
                copy.random = iter.random.next; //point to the copy of the random instead of random itself
            }
            iter = iter.next.next; //go to the next original node
        }

        //3rd pass
        iter = head;
        RandomNode dummy = new RandomNode(0);
        RandomNode copy, copyIter = dummy;

        while(iter != null){
            next = iter.next.next;

            //extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            //restore the original list
            iter.next = next;
            iter = next;

        }
        return dummy.next;
    }

    /*
    the inner ListNode Class
     */
    private static class Node {
        public Node next = null;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private static class RandomNode {
        public RandomNode next;
        public RandomNode random;
        public int value;

        public RandomNode(int value){
            this.value = value;
        }
    }
}
