package com.ny.vanhack;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MeetupSchedule {

    /*
     * Complete the 'countMeetings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY firstDay
     *  2. INTEGER_ARRAY lastDay
     */
    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {

        int[][] investorDays = new int[firstDay.size()][2];
        for (int i = 0; i < firstDay.size(); i++) {
            investorDays[i][0] = firstDay.get(i);
            investorDays[i][1] = lastDay.get(i);
        }
        Arrays.sort(investorDays, (e1, e2) -> {
            int x = Integer.compare(e1[1], e2[1]);
            if (x != 0) return x;
            else return Integer.compare(e1[0], e2[0]);
        });

        int finalDayOfMeeting = investorDays[investorDays.length - 1][1];
        boolean[] availableDays = new boolean[finalDayOfMeeting + 1];
        int meetings = 0;
        for (int[] eachInvestorDays : investorDays) {
            int start = eachInvestorDays[0];
            int end = eachInvestorDays[1];
            while (start <= end) {
                if (!availableDays[start]) {
                    availableDays[start] = true;
                    meetings++;
                    break;
                } else {
                    start++;
                }
            }

        }
        return meetings;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int firstDayCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> firstDay = IntStream.range(0, firstDayCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int lastDayCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> lastDay = IntStream.range(0, lastDayCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = countMeetings(firstDay, lastDay);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}