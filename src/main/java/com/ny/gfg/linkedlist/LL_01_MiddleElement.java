package com.ny.gfg.linkedlist;

import java.io.File;
import java.util.Scanner;

public class LL_01_MiddleElement {

    public static void main(String[] args) throws Exception {
        final Scanner in = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
//      Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = in.nextInt();
            LL linkedList = new LL();
            LL.Node head = new LL.Node(in.nextInt());
            linkedList.addToTheLast(head);
            for (int j = 1; j < n; j++) {
                linkedList.addToTheLast(new LL.Node(in.nextInt()));
            }
            LL middleElement = new LL();
            int middleData = middleElement.getMiddle(linkedList.getHead());
            System.out.println(middleData);
        }
        in.close();
    }
}
