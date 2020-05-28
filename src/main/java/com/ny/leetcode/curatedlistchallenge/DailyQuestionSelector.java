package com.ny.leetcode.curatedlistchallenge;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class DailyQuestionSelector {

    private static final Set<Integer> COMPLETED_QUESTIONS = new HashSet<>();
    private static final Set<Integer> ALMOST_COMPLETE_QUESTIONS = new HashSet<>();
    private static final Set<Integer> NEED_HELP_QUESTIONS = new HashSet<>();
    private static int count = 6;

    static {
        //Day-0
        COMPLETED_QUESTIONS.add(1);//Two Sum
        COMPLETED_QUESTIONS.add(60);//Maximum Depth of Binary Tree
        COMPLETED_QUESTIONS.add(61);//Same Tree

        //Day-1
        NEED_HELP_QUESTIONS.add(32);//Alien Dictionary (Premium)
        ALMOST_COMPLETE_QUESTIONS.add(65);//Serialize and Deserialize Binary Tree
        COMPLETED_QUESTIONS.add(25);//Unique Paths
        COMPLETED_QUESTIONS.add(49);//Word Search
        ALMOST_COMPLETE_QUESTIONS.add(50);//Longest Substring Without Repeating Characters
        COMPLETED_QUESTIONS.add(48);//Rotate Image

        //Day-2
        COMPLETED_QUESTIONS.add(40);//Reverse a Linked List
        COMPLETED_QUESTIONS.add(44);//Remove Nth Node From End Of List
        COMPLETED_QUESTIONS.add(36);//Merge Intervals
        ALMOST_COMPLETE_QUESTIONS.add(26);//Jump Game

        /* Day-3 */
        COMPLETED_QUESTIONS.add(68);//Validate Binary Search Tree
        COMPLETED_QUESTIONS.add(16);//Climbing Stairs
        COMPLETED_QUESTIONS.add(74);//Merge K Sorted Lists
        COMPLETED_QUESTIONS.add(22);//House Robber
        COMPLETED_QUESTIONS.add(71);//Implement Trie (Prefix Tree)

        /* Day-4 */
        COMPLETED_QUESTIONS.add(14);//Missing Number
        ALMOST_COMPLETE_QUESTIONS.add(19);//Longest Common Subsequence
        ALMOST_COMPLETE_QUESTIONS.add(37);//Non-overlapping Intervals
        COMPLETED_QUESTIONS.add(46);//Set Matrix Zeroes
        NEED_HELP_QUESTIONS.add(17);//Coin Change

        /* Day-5 */
        COMPLETED_QUESTIONS.add(6);//Maximum Product Subarray
        ALMOST_COMPLETE_QUESTIONS.add(33);//Graph Valid Tree
        COMPLETED_QUESTIONS.add(53);//Valid Anagram

        /* Day-6 */
        ALMOST_COMPLETE_QUESTIONS.add(11);//Sum of Two Integers
        NEED_HELP_QUESTIONS.add(21);//Combination Sum
        COMPLETED_QUESTIONS.add(27);//Clone Graph
        NEED_HELP_QUESTIONS.add(38);//Meeting Rooms II
        NEED_HELP_QUESTIONS.add(51);//Longest Repeating Character Replacement
        COMPLETED_QUESTIONS.add(69);//Kth Smallest Element in a BST

        /* Day-7 */
        /*COMPLETED_QUESTIONS.add(5);//Maximum Subarray
        COMPLETED_QUESTIONS.add(34);//Number of Connected Components in an Undirected Graph
        COMPLETED_QUESTIONS.add(52);//Minimum Window Substring
        COMPLETED_QUESTIONS.add(62);//Invert/Flip Binary Tree
        COMPLETED_QUESTIONS.add(64);//Binary Tree Level Order Traversal
        COMPLETED_QUESTIONS.add(73);//Word Search II*/
    }

    public static void main(String[] args) {
        Set<Integer> todaysQuestions = new HashSet<>();
        Random random = new Random();

        while (count > 0) {
            int newQuestion = random.nextInt(76) + 1; /* from 1 to 76 */
            if (!COMPLETED_QUESTIONS.contains(newQuestion) &&
                    !NEED_HELP_QUESTIONS.contains(newQuestion) &&
                    !ALMOST_COMPLETE_QUESTIONS.contains(newQuestion) &&
                    !todaysQuestions.contains(newQuestion)
            ) {
                todaysQuestions.add(newQuestion);
                count--;
            }
        }
        System.out.println(todaysQuestions.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ",
                        "Do the following questions today\r\n",
                        "\r\nALL THE BEST")));

    }

}


