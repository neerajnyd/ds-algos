package com.ny.leetcode.march2023;

public class AddSearchWords {

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

    }

private static class WordDictionary {

    private final Node root = new Node();

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            node = node.setChild(c);
        }
        node.setWord();
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] word, int pos, Node node) {
        boolean lastChar = pos == word.length;
        if (lastChar) return node.isWord();
        char c = word[pos];
        if (c != '.') {
            return node.getChild(c) != null && search(word, pos + 1, node.getChild(c));
        }
        //search all children nodes for matching .
        for (int i = 0; i < node.size(); i++) { //node size is always 26
            if (node.getChild(i) != null && search(word, pos + 1, node.getChild(i))) {
                return true;
            }
        }
        return false;
    }

    private static class Node {

        private final Node[] children = new Node[26];
        private boolean word = false;

        public Node getChild(int i) {
            return this.children[i];
        }

        public Node getChild(char c) {
            return this.getChild(c - 'a');
        }

        public Node setChild(char c) {
            return this.setChild(c - 'a');
        }

        public Node setChild(int i) {

            if (this.children[i] == null) {
                Node child = new Node();
                this.children[i] = child;
                return child;
            } else return this.children[i];
        }

        public void setWord() {
            this.word = true;
        }

        public boolean isWord() {
            return word;
        }

        public int size() {
            return this.children.length;
        }

    }

}

}
