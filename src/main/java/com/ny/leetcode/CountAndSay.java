package com.ny.leetcode;

public class CountAndSay {

    public static void main(String[] args) {

        for(int i =1; i<=10; i++){
            String count = countAndSay(i);
            System.out.println(count);
        }

    }

    private static String countAndSay(int n) {

        String count = "1";

        for(int i = 1; i < n; i++){
            count = getNewCountEnhanced(count);
        }

        return count;

    }

    private static String getNewCount(String count) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        char[] chars = count.toCharArray();
        char currChar = chars[0];

        for(int i=0; i<chars.length; i++){
            if(currChar == chars[i]){
                num++;
                continue;
            }

            sb.append(num).append(chars[i-1]);
            num = 1;
            currChar = chars[i];
        }
        sb.append(num).append(currChar);

        return sb.toString();
    }

    private static String getNewCountEnhanced(String input) {

        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<input.length(); i++){

            ++counter;
            if(i == input.length()-1 || input.charAt(i) != input.charAt(i+1)){
                stringBuilder.append(counter).append(input.charAt(i));
                counter = 0;
            }

        }

        return stringBuilder.toString();

    }

}
