package com.ny.gfg.linkedlist;

public class LL {

    private Node head;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public int getMiddle(LL.Node head) {
        if (head != null) {
            int n = getLength(head);

            n = n / 2;
            LL.Node t = head;
            while (n-- > 0) {
                t = t.next;
            }
            return t.data;
        } else {
            return -1;
        }
    }

    public int getLength(LL.Node head) {
        int x = 0;
        LL.Node t = head;
        while (t != null) {
            t = t.next;
            ++x;
        }
        return x;
    }

    public Node getHead() {
        return head;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

}
