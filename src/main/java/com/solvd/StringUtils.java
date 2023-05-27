package com.solvd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String decodeString(String input) {
        Pattern pattern = Pattern.compile("(\\d+)\\[([a-zA-Z]*)\\]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int count = Integer.parseInt(matcher.group(1));
            String letters = matcher.group(2);
            input = input.replace(matcher.group(), letters.repeat(count));
            matcher.reset(input);
        }

        return input;
    }

    public static void main(String[] args) {
        String input = "3[a2[b]]";
        System.out.println(decodeString(input)); // Output: abbabbabb
    }
}
