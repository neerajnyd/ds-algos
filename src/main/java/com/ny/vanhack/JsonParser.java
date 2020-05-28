package com.ny.vanhack;

import java.util.*;

public class JsonParser {
    final char[] text;
    int pos;
    Map<String, Object> parsedObject;

    public JsonParser(String jsonString) {
        this.text = jsonString.toCharArray();
        this.pos = 0;
    }

    public Map<String, Object> parse() {
        if (parsedObject == null) {
            parsedObject = parseJsonResponse();
        }
        return parsedObject;
    }

    private Map<String, Object> parseJsonResponse() {
        final Map<String, Object> jsonObject = new HashMap<>();
        skipWhitespaces();
        skip('{');

        while (text[pos] != '}') {
            skip(',');
            final String key = parseString();
            skip(':');
            final Object value = parseValue();
            jsonObject.put(key, value);
            skip(',');
        }
        skip('}');
        return jsonObject;
    }

    private List<Map<String, Object>> parseArrayObject() {
        final List<Map<String, Object>> arrayObject = new ArrayList<>();
        skipWhitespaces();
        skip('[');
        while (text[pos] != ']') {
            skip(',');
            final Map<String, Object> jsonObject = parseJsonResponse();
            arrayObject.add(jsonObject);
        }
        skip(']');
        return arrayObject;
    }

    private Object parseValue() {
        skipWhitespaces();
        final char c = text[pos];
        if (c == '"') {
            return parseString();
        }
        if (c == '-' || c == '+' || Character.isDigit(c)) {
            return parseNumber();
        }
        if (c == '{') {
            return parseJsonResponse();
        }
        if (c == '[') {
            return parseArrayObject();
        }
        if (c == 't') {
            return parseConstant("true", Boolean.TRUE);
        }
        if (c == 't') {
            return parseConstant("false", Boolean.FALSE);
        }
        return parseConstant("null", null);
    }

    private Object parseConstant(String name, Object object) {
        skipWhitespaces();
        for (char c : name.toCharArray()) {
            skip(c);
        }
        return object;
    }

    private Long parseNumber() {
        int sign = +1;
        long number = 0;
        skip('+');
        if (text[pos] == '-') {
            skip('-');
            sign = -1;
        }
        while (Character.isDigit(text[pos])) {
            number = number * 10 + (text[pos++] - '0');
        }
        return sign * number;
    }

    private String parseString() {
        final StringBuilder sb = new StringBuilder();
        skip('"');
        while (text[pos] != '"') {
            sb.append(text[pos++]);
        }
        skip('"');
        return sb.toString();
    }

    private void skip(char ch) {
        skipWhitespaces();
        if (text[pos] == ch) {
            pos++; // ckip ch
            skipWhitespaces();
        }
    }

    private boolean skipWhitespaces() {
        while (pos < text.length && Character.isWhitespace(text[pos])) {
            pos++;
        }
        return pos < text.length;
    }

    public static void main(String[] args) {

        JsonParser parser = new JsonParser("{\"page\":\"2\",\"per_page\":10,\"total\":79,\"total_pages\":8,\"data\":[{\"id\":32,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1552272823149,\"txnType\":\"credit\",\"amount\":\"$1,223.37\",\"location\":{\"id\":8,\"address\":\"389, Everest, Barwell Terrace\",\"city\":\"Murillo\",\"zipCode\":66061},\"ip\":\"5.116.1.11\"},{\"id\":37,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1549270877608,\"txnType\":\"debit\",\"amount\":\"$2,930.80\",\"location\":{\"id\":9,\"address\":\"961, Neptide, Elliott Walk\",\"city\":\"Bourg\",\"zipCode\":68602},\"ip\":\"132.169.40.222\"},{\"id\":40,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1552930339010,\"txnType\":\"debit\",\"amount\":\"$2,277.37\",\"location\":{\"id\":7,\"address\":\"770, Deepends, Stockton Street\",\"city\":\"Ripley\",\"zipCode\":44139},\"ip\":\"119.162.205.226\"},{\"id\":41,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1549153767183,\"txnType\":\"credit\",\"amount\":\"$344.83\",\"location\":{\"id\":9,\"address\":\"961, Neptide, Elliott Walk\",\"city\":\"Bourg\",\"zipCode\":68602},\"ip\":\"111.83.155.103\"},{\"id\":49,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1553586814900,\"txnType\":\"credit\",\"amount\":\"$887.64\",\"location\":{\"id\":6,\"address\":\"206, Portaline, Brooklyn Avenue\",\"city\":\"Brownlee\",\"zipCode\":80358},\"ip\":\"5.116.1.11\"},{\"id\":53,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1553267416245,\"txnType\":\"credit\",\"amount\":\"$1,290.39\",\"location\":{\"id\":8,\"address\":\"389, Everest, Barwell Terrace\",\"city\":\"Murillo\",\"zipCode\":66061},\"ip\":\"111.83.155.103\"},{\"id\":57,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1551156445951,\"txnType\":\"credit\",\"amount\":\"$1,594.80\",\"location\":{\"id\":6,\"address\":\"206, Portaline, Brooklyn Avenue\",\"city\":\"Brownlee\",\"zipCode\":80358},\"ip\":\"5.116.1.11\"},{\"id\":60,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1548043036666,\"txnType\":\"debit\",\"amount\":\"$725.68\",\"location\":{\"id\":8,\"address\":\"389, Everest, Barwell Terrace\",\"city\":\"Murillo\",\"zipCode\":66061},\"ip\":\"119.162.205.226\"},{\"id\":64,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1553702507589,\"txnType\":\"debit\",\"amount\":\"$2,007.76\",\"location\":{\"id\":8,\"address\":\"389, Everest, Barwell Terrace\",\"city\":\"Murillo\",\"zipCode\":66061},\"ip\":\"119.162.205.226\"},{\"id\":65,\"userId\":1,\"userName\":\"John Oliver\",\"timestamp\":1547973103855,\"txnType\":\"debit\",\"amount\":\"$812.07\",\"location\":{\"id\":6,\"address\":\"206, Portaline, Brooklyn Avenue\",\"city\":\"Brownlee\",\"zipCode\":80358},\"ip\":\"5.116.1.11\"}]}");
        Map<String, Object> jsonObject = parser.parse();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();
        }

    }

}
