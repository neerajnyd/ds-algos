package com.ny.leetcode.march2023;

public class ImplementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

private static class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) return;

        Node curr = root;
        for (char c : word.toCharArray()) {
            int i = Character.getNumericValue(c) - 10; // 'a' is 10 so our range becomes 0 to 25 after subtracting 10
            if (curr.getChild(i) == null) {
                curr.setChild(i);
            }
            curr = curr.getChild(i);
        }
        curr.setWord();
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int i = Character.getNumericValue(c) - 10;
            if (curr.getChild(i) == null) {
                return false;
            }
            curr = curr.getChild(i);

        }
        return curr.isWord();
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int i = Character.getNumericValue(c) - 10;
            if (curr.getChild(i) == null) {
                return false;
            }
            curr = curr.getChild(i);
        }
        return true;
    }

    private static class Node {
        private boolean word = false;
        private final Node[] children = new Node[26];

        public void setWord() {
            this.word = true;
        }

        public boolean isWord() {
            return word;
        }

        public Node getChild(int i) {
            return children[i];
        }

        public void setChild(int i) {
            this.children[i] = new Node();
        }
    }
}
}
