package com.ny.model;

public class BTNode {

    int data;
    BTNode left;
    BTNode right;

    public BTNode(int data) {
        this.data = data;
    }

    public BTNode(int data, BTNode left, BTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
