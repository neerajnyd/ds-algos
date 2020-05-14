package com.ny.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws Exception{

        LocalDate date = LocalDate.now();
        System.out.println(date.plusDays(365));

	}

    private static int countBits(int num) {
		int numBits = 0;
        while (num != 0) {
			int getOnesInNumber = num & 1; //AND with mask of 0001 to see if LSB is a 1
			numBits += getOnesInNumber;
			num = num >>> 1;
        }
        return numBits;
    }

	private static int parity(int num) {
		int parity = 0;
        while (num != 0) {
			int getOnesInNumber = num & 1; //AND with mask of 0001 to see if LSB is a 1
			parity ^= getOnesInNumber;
			num = num >>> 1;
        }
        return parity;
    }

	private static int parity2(int num) {
		int p = 0;
        while (num != 0) {
        	p ^= 1;
        	num &= (num-1); //drop the lowest set bit (i.e. bit 1) to 0
        }
        return p;
    }

    public static void sortingMap() {
        Map<String, String> map = new HashMap<>();
        map.put("abc", "neeraj");
        final Map<String, String> collect = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, o2) -> o2, LinkedHashMap::new));
    }

    private static void internTest() {
        String y = "Neeraj";
        String z = new String("Neeraj");
        String w = z.intern();
        String x = "Neeraj";

        if (x == y) {
            System.out.println("same memory location");
        } else {
            System.out.println("Different memory location");
        }

        if (w == x) {
            System.out.println("same memory location");
        } else {
            System.out.println("Different memory location");
        }
    }

    private static void characterPrint() {
        final char c = (char) ('0' + 1);
        System.out.println(c);
    }

    public static void genericTest(List<? super Number> list) {
        List<Number> list2 = new ArrayList<>();
        list.add(1);

    }

    public static int ascii_deletion_distance(String str1, String str2) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        for (int i = 0; i < c1.length; i++) {

            if (!map1.containsKey(c1[i])) {

                map1.put(c1[i], 1);
            } else {
                map1.put(c1[i], map1.get(c1[i]) + 1);
            }
        }

        for (int i = 0; i < c2.length; i++) {

            if (!map2.containsKey(c2[i])) {

                map2.put(c2[i], 1);
            } else {
                map2.put(c2[i], map2.get(c2[i]) + 1);
            }
        }
        int distance = 0;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int d = Math.abs(map1.get(entry.getKey()) - map2.get(entry.getKey()));
                char charKey = entry.getKey();
                distance += (int) charKey * d;
            }
        }
        return distance;

    }

    public static int four_letter_words(String sentence) {

        String[] a = sentence.split(" ");
        int count = 0;
        for (String s : a) {
            if (s.length() == 4) {
                count++;
            }
        }

        return count;

    }

    private static int almost_palindromes(String str) {
        char[] c1 = str.toCharArray();
        String reverse = new StringBuilder(str).reverse().toString();
        char[] c2 = reverse.toCharArray();

        int count = 0;


        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                count++;
            }
        }

        return count;
    }

    private static int brackets() {
        String bracket_string = "(()))";

        char chars[] = bracket_string.toCharArray();
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                c1++;
            } else {
                c2++;
            }

        }
        return Math.abs(c1 - c2);
    }

    private static void dateFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateString = "20171116";
        LocalDate ldt = LocalDate.parse(dateString, formatter);

        LocalDateTime ldtime = ldt.atTime(LocalTime.now());

        System.out.println(ldt);
        System.out.println(ldtime);
    }


    private static void lexicalScoping() {

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors =
                Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades =
                Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

        Function<String, Predicate> startsWithLetter = (letter) -> {
            Predicate<String> predicate = name -> name.startsWith(letter);
            return predicate;
        };

        friends.stream().filter(startsWithLetter.apply("N")).forEach(System.out::println);
        System.out.println();
        editors.stream().filter(checkIfStartsWith("B")).forEach(System.out::println);
        System.out.println();
        comrades.stream().filter(checkIfStartsWith("N")).forEach(System.out::println);

    }

    private static Predicate<String> checkIfStartsWith(String letter) {
        return name -> name.startsWith(letter);
    }

    private static void nullCheck() {

        Long value = null;

        if (0 <= value) {
            System.out.println(value);
        } else {
            System.out.println("less than zero");
        }

    }

    private static void twoDArraySum() {

        int[][] a = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {


            }
        }

    }

    private static void addOneDayToDate(String dateStr) throws ParseException {

        Date date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date newDate = cal.getTime();
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(newDate));
    }

    private static void replaceWithNullTest() {

        String str = "stringWithPlaceholder";
        str = str.replace("{date}", null);
        System.out.println(str);
    }

    private static void dateFormatTest() {
        LocalDate ld = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println("Should print 20171004. Prints: " + formatter.format(ld));

        String dateString = "2017003";
        LocalDate parsedDate = LocalDate.parse(dateString, formatter);
        System.out.println("Should print 20171003. Prints: " + formatter.format(parsedDate));

    }

    private static String reverse(String str) {
        char[] in = str.toCharArray();

        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (begin < end) {
            temp = in[end];
            in[end] = in[begin];
            in[begin] = temp;
            begin++;
            end--;
        }
        return new String(in);
    }

    private static String reverseString1(String str) {

        char[] chars = str.toCharArray();
        char[] reverse = new char[str.length()];

        int start = 0;
        int end = chars.length - 1;

        for (int i = 0; i < chars.length; i++) {
            reverse[i] = chars[end];
            end--;
        }
        return new String(reverse);

    }

}
