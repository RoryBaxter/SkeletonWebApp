package com.develogical;

import java.util.ArrayList;
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
            String numbersString = cleanSpace(removePunt(removeChars(query)));
            List<String> numbersList = reomveNull(numbersString.split(","));
            int largest = Integer.parseInt(numbersList.get(0));
            for (String n : numbersList) {
                int l = Integer.parseInt(n);
                if (l> largest) {
                    largest = l;
                }
            }
            return String.valueOf(largest);

        } else if (query.toLowerCase().contains("plus")) {
            String numbersString = removeChars(query).strip();
            List<String> numbersList = reomveNull(numbersString.split(" "));

            return String.valueOf(Integer.valueOf(numbersList.get(0)) + Integer.valueOf(numbersList.get(1)));
        } else if (query.toLowerCase().contains("multiplied")) {
            String numbersString = cleanSpace(removeChars(query));
            String[] numbersList = numbersString.split(" ");
            return String.valueOf(Integer.valueOf(numbersList[0]) * Integer.valueOf(numbersList[1]));
        } else if (query.toLowerCase().contains("square and a cube")) {
            return squareAndCube(stringToListOfNumbers(query));
        }

        return "";
    }

    public String squareAndCube(List<Integer> numbersList) {
        for (Integer n : numbersList) {
            int sqrt = (int)Math.sqrt(n);
            if (Math.pow(sqrt, 2) == n) {
                int cubeRoot = (int)Math.cbrt(n);
                if (Math.pow(cubeRoot, 3) == n) {
                    return String.valueOf(n);
                }
            }
        }
        return null;
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

    public static String cleanSpace(String input) {
        String output = input.toLowerCase();
        for (int i = 0; i<input.length(); i++) {
            output = output.replace("  ", "");
        }

        return output.strip();
    }

    public List<String> reomveNull(String[] input) {
        List<String> output = new ArrayList<>();
        int size = 0;
        for (String n : input) {
            if (n != " " && n != "") {
                output.add(n);
            }
        }
        return output;
    }

    public List<Integer> reomveNull2(String[] input) {
        List<Integer> output = new ArrayList<>();
        int size = 0;
        for (String n : input) {
            if (n != " " && n != "") {
                output.add(Integer.valueOf(n));
            }
        }
        return output;
    }


    public List<Integer> stringToListOfNumbers(String input) {
        String noChars = removeChars(input);
        String noPunt = removePunt(noChars).strip();
        String cleanSpace = cleanSpace(noPunt);

        String[] numbersList = cleanSpace.split(",");

        List<Integer> numbersArray = reomveNull2(numbersList);

        return numbersArray;

    }
    
}
