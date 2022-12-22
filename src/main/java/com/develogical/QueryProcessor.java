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
    } else if (query.toLowerCase().contains("largest")) {
        List<Integer> numbersArray = stringToListOfNumbers(query);
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
    } else if (query.toLowerCase().contains("minus")) {
        String numbersString = removeChars(query).strip();
        List<String> numbersList = reomveNull(numbersString.split(" "));

        return String.valueOf(Integer.valueOf(numbersList.get(0)) - Integer.valueOf(numbersList.get(1)));
    } else if (query.toLowerCase().contains("prime")) {
        List<Integer> numbers = stringToListOfNumbers(query);
        for (Integer number : numbers) {
            if (isPrime(number)) {
                return String.valueOf(number);
            }
        }
        return "0";
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
  for (String n : input) {
output.add(n);
  }
  output.removeAll(Arrays.asList("", null));
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

public boolean isPrime(int p) {
    List<Integer> primes = List.of(0, 1,2, 3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,563,569,571,577,587,593,599,601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,769,773,787,797,809,811,821,823,827,829,839,853,857,859,863,877,881,883,887,907,911,919,929,937,941,947,953,967,971,977,983,991,997,1009,1013);
    for (Integer i : primes) {
        if (p == i) {
            return true;
        }
    }
    return false;
}
}
