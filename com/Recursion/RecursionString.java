package com.Recursion;

/** 
 *  @author Priyanshu Raj
 *  @version V1.0
 *  @date 2023-08-18
 */


public class RecursionString {

  /**
   * Removes all occurrences of lowercase 'a' from the input string using
   * recursion.
   *
   * @param input The input string from which to remove 'a' characters.
   * @return A new string with all lowercase 'a' characters removed.
   */
  public static String removeLowerCaseA(String input) {
    if (input.length() == 0) {
      return "";
    }

    char firstChar = input.charAt(0);
    String remainingString = input.substring(1);

    if (firstChar == 'a') {
      return removeLowerCaseA(remainingString);
    } else {
      return firstChar + removeLowerCaseA(remainingString);
    }
  }

  public static void main(String[] args) {
    System.out.println("🌸 Welcome to RecursionString.java 🌸");

    System.out.println("Ques 1");
    String input = "apple is a fruit";
    String result = removeLowerCaseA(input);
    System.out.println("Original: " + input);
    System.out.println("After removing lowercase 'a': " + result);
    System.out.println();

  }
}