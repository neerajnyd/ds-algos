package com.ny.zalando;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestStrWithoutRepeating {
    public static void main(String[] args) throws Exception {

        LongestStrWithoutRepeating class3 = new LongestStrWithoutRepeating();

        System.out.println(class3.solutionRecursive(5, 0, 2));
        System.out.println(class3.solutionRecursive(1, 2, 1));
        System.out.println(class3.solutionRecursive(0, 2, 0));
        System.out.println(class3.solutionRecursive(0, 0, 10));
        System.out.println("'" + class3.solutionRecursive(10, 1000, 10) + "'");

    }

    public String solutionRecursive(int AA, int AB, int BB) {
        if (AA == 0 && AB == 0 && BB == 0) return "";

        List<String> strings = new ArrayList<>();
        if (AA > 0) {
            recurse(--AA, AB, BB, new StringBuilder("AA"), strings);
        }
        if (AB > 0) {
            recurse(AA, --AB, BB, new StringBuilder("AB"), strings);
        }
        if (BB > 0) {
            recurse(AA, AB, --BB, new StringBuilder("BB"), strings);
        }
        Optional<String> maxLength = strings.stream().max(Comparator.comparingInt(String::length));
        return maxLength.orElse("");
    }

    public void recurse(int AA, int AB, int BB, StringBuilder s1, List<String> list) {

        String lastTwo = s1.substring(s1.length() - 2);
        switch (lastTwo) {

            case "AA": {
                StringBuilder s2 = new StringBuilder(s1);
                if (BB == 0) {
                    list.add(s2.toString());
                } else {
                    s2.append("BB");
                    recurse(AA, AB, --BB, s2, list);
                }
                break;
            }
            case "AB":
            case "BB":
                StringBuilder s2 = new StringBuilder(s1);
                if (AA > 0) {
                    s2.append("AA");
                    recurse(--AA, AB, BB, s2, list);
                } else {
                    list.add(s2.toString());
                }
                StringBuilder s3 = new StringBuilder(s1);
                if (AB > 0) {
                    s3.append("AB");
                    recurse(AA, --AB, BB, s3, list);
                } else {
                    list.add(s3.toString());
                }
                break;
        }
    }

    public String solutionIterative(int AA, int AB, int BB) {
        StringBuilder sb = new StringBuilder();

        if (AA >= AB && AA >= BB) {
            sb.append("AA");
            AA--;
        } else if (AB >= AA && AB >= BB) {
            sb.append("AB");
            AB--;
        } //else if (BB >= AA && BB >= AB)
        else {
            sb.append("BB");
            BB--;
        }
        while (AA + AB + BB > 0) {
            int n = sb.length();

            if (sameLastTwoCharacters(sb, n)) {
                if (sb.charAt(n - 1) == 'A' && BB > 0) {
                    sb.append("BB");//AA only gets BB
                    BB--;
                } else if (sb.charAt(n - 1) == 'B' && (AA > 0 || AB > 0)) { //if B
                    if (AB > 0 && AB >= AA) { //BB only AB or AA
                        sb.append("AB");
                        AB--;
                    } else {
                        sb.append("AA");
                        AA--;
                    }
                }
            } else { //last 2 characters are AB
                if (AB > 0 && AB >= AA) { //AB gets AB or AA
                    sb.append("AB");
                    AB--;
                } else if (AA > 0) {
                    sb.append("AA");
                    AA--;
                }
            }
            int n2 = sb.length();
            if (n == n2) break;
        }
        return sb.toString();
    }

    private boolean sameLastTwoCharacters(StringBuilder sb, int n) {
        return sb.charAt(n - 2) == sb.charAt(n - 1);
    }

}
