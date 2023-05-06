package com.solvd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String decodeString(String s) {
        Pattern pattern = Pattern.compile("(\\d+)\\[([a-zA-Z]*)\\]");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            int count = Integer.parseInt(matcher.group(1));
            String letters = matcher.group(2);
            s = s.replace(matcher.group(), letters.repeat(count));
            matcher.reset(s);
        }

        return s;
    }

    public static void main(String[] args) {
        String s = "3[a2[b]]";
        String decoded = decodeString(s);
        System.out.println(decoded); // Output: abbabbabb
    }
}
