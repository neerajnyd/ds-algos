package com.ny.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Random;

public class Util {

    private static final String EASTERN_ZONE_ID = "America/New_York";
    private static final String UNIVERSAL_ZONE_ID = "UTC";

    public static void main(String[] args) throws Exception {
        /*ZonedDateTime easternTime = getNowOfZone(EASTERN_ZONE_ID);
        System.out.println(easternTime);

        System.out.println(getDateRangeForThisYearToDate());

		System.out.println(UNIVERSAL_ZONE_ID + ": " + getNowOfZone(UNIVERSAL_ZONE_ID));*/

        System.out.println(formatDateTime(
                "2020-05-20T03:59:44.347Z",
                "MM/dd/yyyy'T'HH:mm:ss.SSS",
                "-05:00"
        ));

    }

    public static void print2DArray(int[][] A) {
        String s = Arrays.deepToString(A).replace("], ", "]\n");
        System.out.println(s.substring(1, s.length()-1));
        System.out.println();
    }

    public static void print2DArray(char[][] C) {
        String s = Arrays.deepToString(C).replace("], ", "]\n");
        System.out.println(s.substring(1, s.length()-1));
        System.out.println();
    }

    public static void printArray(int[][] A) {
        System.out.println(Arrays.toString(A));
    }

    private static String formatDateTime(String value, String format, String timeZoneOffset) throws Exception{
        OffsetDateTime inputDateTime;
        try {
            inputDateTime = OffsetDateTime.parse(value);
        } catch (DateTimeParseException e) {
            LocalDateTime localDateTime;
            try {
                localDateTime = LocalDateTime.parse(value);
            } catch (DateTimeParseException e1) {
                localDateTime = LocalDate.parse(value).atStartOfDay();
            }
            inputDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.UTC);
        }
        OffsetDateTime outputDateTime = inputDateTime.withOffsetSameInstant(ZoneOffset.of(timeZoneOffset));
        return outputDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    public static ZonedDateTime getNowOfZone(String zoneIdStr) {
        ZoneId zoneId = ZoneId.of(zoneIdStr);
        return ZonedDateTime.now(zoneId);
    }

    private static ZonedDateTime getDateRangeForThisYearToDate() {
		return getNowOfZone(EASTERN_ZONE_ID).
				withMonth(3);
    }

    public static ZonedDateTime offset(ZonedDateTime time, String zoneIdStr) {
        ZoneId zoneId = ZoneId.of(zoneIdStr);
        return time.withZoneSameInstant(zoneId);
    }

    public static int[] getRandomNumberArray() {

        Random random = new Random(System.currentTimeMillis());
        int[] arr = new int[random.nextInt(50)];
        for (int i = 0; i < arr.length; i++) {
            random = new Random(System.nanoTime());
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

}
