package com.ny.vanhack;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class TxnsByLocationAndIp {

    public static void main(String[] args) {
        System.out.println(
                getTransactions(2, 8, 5, 50)
        );
    }

    private static final String SERVICE_URL = "https://jsonmock.hackerrank.com/api/transactions/search?";
    private static final NumberFormat AMOUNT_PARSER = DecimalFormat.getCurrencyInstance(Locale.US);

    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
        final Map<String, Object> queryParameters = new HashMap<>();

        queryParameters.put("userId", userId);
        int page = 1;
        queryParameters.put("page", page);
        int totalPages;
        double totalAmount = 0.0;
        do {
            String transactionResponse = getTransactionData(queryParameters);
            JsonResponseParser parser = new JsonResponseParser(transactionResponse);
            Map<String, Object> parsedJsonData = parser.parse();
            totalPages = ((Long) parsedJsonData.get("total_pages")).intValue();

            List<Map<String, Object>> data = (List<Map<String, Object>>) parsedJsonData.get("data");
            if(data.isEmpty()) break;

            for(Map<String, Object> transactionData : data) {
                if(sameLocation(transactionData, locationId) && ipInRange(transactionData, netStart, netEnd)) {
                    totalAmount += getAmount(transactionData);
                }
            }
            page++;
            queryParameters.replace("page", page);
        } while (page <= totalPages);
        return new BigDecimal(totalAmount).setScale(0, RoundingMode.HALF_UP).intValue();
    }

    public static double getAmount(Map<String, Object> transactionData) {
        String amount = (String) transactionData.get("amount");
        try {
            Number parsedNumber = AMOUNT_PARSER.parse(amount);
            return parsedNumber.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static boolean ipInRange(Map<String, Object> transactionData, int netStart, int netEnd) {
        String[] ipBytes = ((String) transactionData.get("ip")).split("\\.");
        int firstIpByte = Integer.parseInt(ipBytes[0]);
        return firstIpByte >= netStart && firstIpByte <= netEnd;
    }

    private static boolean sameLocation(Map<String, Object> transactionData, int locationId) {
        Map<String, Object> locationData = (Map<String, Object>) transactionData.get("location");
        int dLocationId = ((Long) locationData.get("id")).intValue();
        return dLocationId == locationId;
    }

    private static String getTransactionData(Map<String, Object> queryParameters) {
        //userId=%s&page=%s
        final String queryParametersStr = queryParameters.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));

        try {
            final URL url = new URL(SERVICE_URL + queryParametersStr);
            final URLConnection connection = url.openConnection();
            final InputStream responseInputStream = connection.getInputStream();
            return new BufferedReader(new InputStreamReader(responseInputStream))
                    .lines()
                    .collect(Collectors.joining());

        } catch (IOException e) {
            e.printStackTrace();
            throw new UncheckedIOException(e);
        }
    }

    private static class JsonResponseParser {
        Map<String, Object> parsedObject;
        int pos;
        final char[] jsonStr;

        public JsonResponseParser(String jsonStr) {
            this.pos = 0;
            this.jsonStr = jsonStr.toCharArray();
        }

        public Map<String, Object> parse() {
            if (parsedObject == null) {
                parsedObject = parseJsonObject();
            }
            return parsedObject;
        }

        private Map<String, Object> parseJsonObject() {
            final Map<String, Object> map = new HashMap<>();
            skip();
            skip('{');

            while (jsonStr[pos] != '}') {
                skip(',');
                final String key = parseString();
                skip(':');
                final Object value = parseValue();
                map.put(key, value);
                skip(',');
            }
            skip('}');
            return map;
        }

        private Object parseValue() {
            skip();
            final char c = jsonStr[pos];
            if (c == '"') {
                return parseString();
            }
            if (Character.isDigit(c)) {
                return parseNumber();
            }
            if (c == '{') {
                return parseJsonObject();
            }
            if (c == '[') {
                return parseArrayObject();
            }
            return parseConstant("null", null);
        }

        private List<Map<String, Object>> parseArrayObject() {
            final List<Map<String, Object>> list = new ArrayList<>();
            skip();
            skip('[');
            while (jsonStr[pos] != ']') {
                skip(',');
                final Map<String, Object> jsonObject = parseJsonObject();
                list.add(jsonObject);
            }
            skip(']');
            return list;
        }

        private Object parseConstant(String name, Object object) {
            skip();
            for (char c : name.toCharArray()) {
                skip(c);
            }
            return object;
        }

        private void skip() {
            while (pos < jsonStr.length && Character.isWhitespace(jsonStr[pos])) {
                pos++;
            }
        }

        private void skip(char ch) {
            skip();
            if (jsonStr[pos] == ch) {
                pos++; //
                skip();
            }
        }

        private Long parseNumber() {
            int sign = +1;
            long number = 0;
            skip('+');
            if (jsonStr[pos] == '-') {
                skip('-');
                sign = -1;
            }
            while (Character.isDigit(jsonStr[pos])) {
                number = number * 10 + (jsonStr[pos++] - '0');
            }
            return sign * number;
        }

        private String parseString() {
            final StringBuilder sb = new StringBuilder();
            skip('"');
            while (jsonStr[pos] != '"') {
                sb.append(jsonStr[pos++]);
            }
            skip('"');
            return sb.toString();
        }
    }

    /*public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("")));

        int userId = Integer.parseInt(bufferedReader.readLine().trim());

        int locationId = Integer.parseInt(bufferedReader.readLine().trim());

        int netStart = Integer.parseInt(bufferedReader.readLine().trim());

        int netEnd = Integer.parseInt(bufferedReader.readLine().trim());

        int result = TxnsByLocationAndIp.getTransactions(userId, locationId, netStart, netEnd);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }*/

}
