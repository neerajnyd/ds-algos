package com.ny.leetcode.curatedlistchallenge.day2;

/*
https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    private final Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new Node();
            cur = cur.children[index];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    private static class Node {
        public Node[] children;
        public boolean end;

        public Node() {
            children = new Node[26];
            end = false;
        }
    }
}
