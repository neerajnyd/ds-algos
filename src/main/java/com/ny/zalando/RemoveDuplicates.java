package com.ny.zalando;

public class RemoveDuplicates {

    public static void main(String[] args) throws Exception {

        RemoveDuplicates three = new RemoveDuplicates();
        System.out.println(three.removeDuplicatesStack("ABABABABABABABACDCDCDCDCDCACDCDCDB"));


    }

    private String removeDuplicatesStack(String S) {
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (sb.length() > 0 && pairCharacter(c, sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean pairCharacter(char first, char second) {
        return first == 'A' && second == 'B' ||
                first == 'B' && second == 'A' ||
                first == 'C' && second == 'D' ||
                first == 'D' && second == 'C';
    }
}
