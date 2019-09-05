package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static void main(String args[])
    {
        System.out.println("c:\\windows\\system32");
        String s = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1 \"\"\"Alexandra Alex\"\"\"";
        System.out.println(parseCSV(s));
    }

    //"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1 """Alexandra Alex"""
    // The real trick is by rule a double quote in a csv field is escaped by another double quote in front
    public static String parseCSV(String str) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuote = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (inQuote) {
                if (c == '\"') {
                    if (i + 1 < str.length() && str.charAt(i + 1) == '\"') {
                        sb.append('\"');
                        i++;
                    } else {
                        inQuote = false;
                    }
                } else {
                    sb.append(c);
                }
            } else {
                if (c == '\"') {
                    inQuote = true;
                } else if (c == ',') {
                    list.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        return String.join("|", list);
    }
}
