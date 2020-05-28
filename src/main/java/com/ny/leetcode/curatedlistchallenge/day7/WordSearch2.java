package com.ny.leetcode.curatedlistchallenge.day7;

import java.util.List;

/*
https://leetcode.com/problems/word-search-ii/

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once in a word.

Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
 */
public class WordSearch2 {

    public static List<String> findWords(char[][] board, String[] words) {

        return null;
    }

    public static void main(String[] args) {
        char[][] B = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {
                "oath","pea","eat","rain"
        };
        System.out.println(findWords(B, words));
    }
}
