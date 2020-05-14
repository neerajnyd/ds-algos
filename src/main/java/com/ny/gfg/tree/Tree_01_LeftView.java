package com.ny.gfg.tree;

import java.io.BufferedReader;
import java.io.FileReader;

public class Tree_01_LeftView {

    public static void main(String[] args) throws Exception {

        final BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\NY\\Desktop\\tc.txt"));
//      final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String s = reader.readLine();
            Tree tree = new Tree();
            Tree.Node root = tree.buildTree(s);
            tree.leftView(root);
            System.out.println();
        }
    }
}
