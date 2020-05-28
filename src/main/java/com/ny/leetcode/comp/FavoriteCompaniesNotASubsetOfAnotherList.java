package com.ny.leetcode.comp;

import java.util.*;

/*
https://leetcode.com/contest/weekly-contest-189/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 */
@SuppressWarnings("ALL")
public class FavoriteCompaniesNotASubsetOfAnotherList {

    public static void main(String[] args) {

        String[][] companies = {{"leetcode", "google", "facebook"}, {"leetcode", "amazon"}, {"facebook", "google"}};


        List<List<String>> companiesList = twoDArrayToList(companies);
        System.out.println(
                peopleIndexes2(companiesList)
        );
    }

    public static List<Integer> peopleIndexes(List<List<String>> comps) {
        List<Set<String>> sets = new ArrayList<>();
        for (List<String> x : comps)
            sets.add(new HashSet<>(x));

        List<Integer> R = new ArrayList<>();
        outer:
        for (int i = 0; i < comps.size(); i++) {
            inner:
            for (int j = 0; j < comps.size(); j++) {
                if (i == j) continue;
                for (String y : comps.get(i)) {
                    if (!sets.get(j).contains(y)) {
                        continue inner;
                    }
                }
                continue outer;
            }
            R.add(i);
        }
        return R;
    }

    public static List<List<String>> twoDArrayToList(String[][] twoDArray) {
        List<List<String>> lists = new ArrayList<>();
        for (String[] ints : twoDArray) {
            lists.add(Arrays.asList(ints));
        }
        return lists;
    }

    public static List<Integer> peopleIndexes2(List<List<String>> favoriteCompanies) {

        List<Set<String>> list = new LinkedList();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < favoriteCompanies.size(); i++) {

            boolean flag = false;
            for (Set<String> set : list) {

                if (set.containsAll(favoriteCompanies.get(i))) {
                    flag = true;
                    break;
                }
            }

            list.add(new HashSet(favoriteCompanies.get(i)));
            if (!flag)
                res.add(i);
        }

        Collections.sort(res);
        return res;
    }

}
