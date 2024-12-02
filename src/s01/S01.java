/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01;

import java.util.Scanner;

/**
 * S01 - Reverse a string; convert to upper case and vice versa.
 *
 * @author NhutBM_CE180569
 */
public class S01 {

    /**
     * Get a string from user
     *
     * @return the string after the condition with do while loop
     */
    public String getString() {
        String str = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a string: ");
            str = sc.nextLine();
            if (str.isEmpty()) {
                System.out.println("The string cannot be empty!");
            }
            if (isCheckSpecialCharacters(str)) {
                System.out.println("The string must be all letter!");
            }
        } while (isCheckSpecialCharacters(str) || str.isEmpty());
        return str;
    }

    /**
     * Converts all uppercase characters in the input string to lowercase and
     * all lowercase characters to uppercase.
     *
     * @param str The input string to be converted.
     * @return A new string with all uppercase characters converted to lowercase
     * and vice versa.
     */
    public String toUpperAndLowerString(String str) {
        // Initialize an empty string to hold the processed characters
        String temp = "";
        // Iterate through each character in the input string
        for (int i = 0; i < str.length(); i++) {
            // Get the current character
            char kyTu = str.charAt(i);
            // Check if the character is uppercase
            if (Character.isUpperCase(kyTu)) {
                // Convert uppercase to lowercase
                temp += Character.toLowerCase(kyTu);
            } else if (Character.isLowerCase(kyTu)) {
                // Convert lowercase to uppercase
                temp += Character.toUpperCase(kyTu);
            } else {
                // If the character is neither, append it as is
                temp += kyTu;
            }
        }
        // Return the final processed string
        return temp;
    }

    /**
     * Reverse the string
     *
     * @param str the string will be reversed
     * @return the string after reverse
     */
    public String reverseString(String str) {
        String newString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            newString += str.charAt(i);
        }
        return newString;
    }

    /**
     * Checks if the input string contains any special characters, digits, or
     * punctuation marks.
     *
     * @param str the input string to check
     * @return true if the string contains invalid characters or invalid
     * structure, false otherwise
     */
    public boolean isCheckSpecialCharacters(String str) {
        // Check if the string has only one character and it is a special character, digit, or punctuation
        if (str.length() == 1) {
            char c = str.charAt(0);
            if (!Character.isLetter(c) && c != ' ') {
                return true;
            }
        }

        // Check for special characters other than . ! ? at the end of the string and ensure no digits
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && !(i == str.length() - 1 && (c == '.' || c == '!' || c == '?'))) {
                return true;
            }
        }

        // Check if . ! ? appear at the beginning or middle of the string
        if (str.length() > 1) {
            char lastChar = str.charAt(str.length() - 1);
            if (lastChar == '.' || lastChar == '!' || lastChar == '?') {
                String middleString = str.substring(0, str.length() - 1);
                if (middleString.contains(".") || middleString.contains("!") || middleString.contains("?")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * The main method
     *
     * @param args argument of main method
     */
    public static void main(String[] args) {
        System.out.println("This program help you converse string and change sensitive case");
        S01 s = new S01();
        String str = s.getString();
        str = s.reverseString(str);
        str = s.toUpperAndLowerString(str);
        System.out.println("\t" + str);
    }
}
