package com.develogical;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("what is your name")) {
            return "Rory";
        } else if (query.toLowerCase().contains("numbers is the largest")) {
            String numbersString = removePunt(removeChars(query));
            String[] numbersList = numbersString.split(",");
            int largest = Integer.parseInt(numbersList[0]);
            for (String n : numbersList) {
                int l = Integer.parseInt(n);
                if (l> largest) {
                    largest = l;
                }
            }
            return String.valueOf(largest);

        } else if (query.toLowerCase().contains("plus")) {
            String numbersString = removeChars(query);
            String[] numbersList = numbersString.split(" ");
            return String.valueOf(Integer.valueOf(numbersList[2]) + Integer.valueOf(numbersList[4]));
        } else if (query.toLowerCase().contains("multi")) {
            String numbersString = removeChars(query);
            String[] numbersList = numbersString.split(" ");
            return String.valueOf(Integer.valueOf(numbersList[2]) * Integer.valueOf(numbersList[4]));
        }

        return "";
    }

    public static String removeChars(String input) {
        String output = input.toLowerCase();
        for (char i : "abcdefghijklmnopqrstuvwxyz?".toCharArray()) {
            output = output.replace(String.valueOf(i), "");
        }
        return output;
    }

    public static String removePunt(String input) {
        String output = input.toLowerCase();
        for (char i : " :?".toCharArray()) {
            output = output.replace(String.valueOf(i), "");
        }
        return output;
    }

    /*public static String cleanSpace(String input) {
        String output = input.toLowerCase();
        for (int i = 0; i<input.length(); i++) {
            output = output.replace("  ", "");
        }

        return output;
    }*/
    
}
