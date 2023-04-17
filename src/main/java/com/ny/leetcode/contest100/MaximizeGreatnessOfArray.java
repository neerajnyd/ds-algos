package com.ny.leetcode.contest100;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximizeGreatnessOfArray {

    public static void main(String[] args) {
        MaximizeGreatnessOfArray m = new MaximizeGreatnessOfArray();
        System.out.println(m.maximizeGreatness(new int[]{
                42, 8, 75, 28, 35, 21, 13, 21
        }));
    }

    private static class Node {
        int val;
        int count;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.count = 1;
        }
    }

    public int maximizeGreatness(int[] nums) {
        Node root = new Node(-1);
        LinkedHashMap<Integer, Node> map = new LinkedHashMap<>();
        //1->3, 2 -> 1, 3->2, 5->1

        List<Integer> sorted = IntStream.of(nums).boxed().sorted().collect(Collectors.toList());
        Node curr = root;
        for (Integer val : sorted) {
            Node node = new Node(val);
            if (map.get(val) == null) {
                map.put(val, node);
                curr.next = node;
                node.prev = curr;
                curr = node;
            } else {
                Node node1 = map.get(val);
                node1.count++;
            }
        }

        int c = 0;

        for (int num : nums) {
            Node node = map.get(num);

            while (true) {
                Node next = node.next;
                if (next == null) break;
                if (next.count > 0) {
                    c++;
                    next.count--;
                    break;
                }
                node = next;
            }

           /* Node next = node.next;
            if (next != null) {
                c++;
                next.count--;
                if (next.count == 0) { //detach next node
                    node.next = next.next;
                    if (next.next != null) {
                        next.next.prev = node;
                    }
                }
            }*/
        }
        return c;

    }

}
