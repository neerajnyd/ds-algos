package com.ny.leetcode.march2023;

public class DesignBrowserHistory {

    public static void main(String[] args) {
/*
    ["BrowserHistory","visit","visit","visit",                       "back","back","forward","visit",        "forward","back","back"]
    [["leetcode"],["google"],["facebook"],["youtube"],[1],   [1],   [1],     ["linkedin"],[2],     [2],     [7]]
 */

        /*
        ["BrowserHistory","visit","back","back","forward","forward","visit","visit","back"]
        [["zav"],       ["kni"],    [7],  [7],   [5],      [1],["pwrrbnw"],["mosohif"],[9]]
         */
        BrowserHistory b = new BrowserHistory("zav");
        b.visit("kni"); //zav -> kni
        System.out.println(b.back(7)); //zav
        System.out.println(b.back(7)); //zav
        System.out.println(b.forward(5)); //kni
        System.out.println(b.forward(1)); //kni
        b.visit("pwrrbnw");
        b.visit("mosohif");
        System.out.println(b.back(9)); //zav

    }

private static class BrowserHistory {

    private Node curr;
    private int size;

    public BrowserHistory(String homepage) {
        this.curr = new Node(homepage);
        this.size = 1;
    }

    /**
     * visit url from current page and clear all forward history
     *
     * @param url url to visit
     */
    public void visit(String url) {
        Node node = new Node(url, curr); //[leetcode, 1] -> [google, 2] -> [facebook, 3]
        this.curr.next = node;
        this.curr = node;
        this.size = this.curr.pos; //3
    }

    /**
     * return x steps in history, where x is in the range of history
     *
     * @param steps no of steps to return. if steps > x, then return x steps
     * @return current url after returning x steps
     */
    public String back(int steps) {

        if (steps == 0) return this.curr.url;

        int n = this.curr.pos; //3

        if (steps < n) {
            n = steps;
        } else {
            n = n - 1;
        }

        for (int i = 0; i < n; i++) {
            this.curr = this.curr.prev;
        }
        return this.curr.url;
    }

    /**
     * go x steps forward in history
     *
     * @param steps no of steps to go forward.
     * @return current url after going x steps forward
     */
    public String forward(int steps) {
        if (steps == 0) return this.curr.url;

        int n = this.size - this.curr.pos;

        if (steps < n) {
            n = steps;
        }

        for (int i = 0; i < n; i++) {
            this.curr = this.curr.next;
        }
        return this.curr.url;
    }

    private static class Node {
        private final String url;
        private Node next;
        private Node prev;
        private final int pos;

        public Node(String url) {
            this.url = url;
            this.pos = 1;
        }

        public Node(String url, Node prev) {
            this.url = url;
            this.prev = prev;
            this.pos = prev.pos + 1;
        }

    }
}

}
