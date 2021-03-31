/*
 * Given a string, do a full justification on it for the given buffer length.
 */

package com.challenges.random.strings;

public class justification {
    /*
     * the following function does a full-justification on the given string for the given buffer
     * @params intput string, buffer length
     */
    public static String justify(String input, int bufferLength) {
        input = input.trim(); //removes all leading and trailing white spaces
        String output = "";
        /*
         *  does not process the input string if either one of the following case is met.
         *  and returns the given input string as output of the function
         */
        if (input == null || input.length() == 0 || bufferLength <= input.length()) {
            return input;
        }
        // breaks the given string(statement) into words
        String[] words = input.split(" ");
        // the number of white spaces present in a string is always 1 less the total number of words in that string
        int whiteSpaceCount = words.length - 1;
        // calculates the extra white spaces that can be added to the given string
        int remainingSpace = bufferLength - input.length();
        // a variable to store the white spaces to be added in addition to the existing one
        int whiteSpacesToAdd = remainingSpace / whiteSpaceCount;
        // the extra white spaces that needs to be added to the string after adding the minimum number of white spaces
        int additionalWhiteSpaces = remainingSpace % whiteSpaceCount;
        // minimum number of white spaces to be added after each word
        int spaceAfterEachWord = 1 + whiteSpacesToAdd;

        /*
         *  the following loop adds the necessary white spaces to the words
         *  first it adds the minimum number of white spaces after each word and then adds any additional whitespace
         *  the additional white spaces are added from left to right
         */
        for (String w : words) {
            output += w;
            for (int i = 0; i < spaceAfterEachWord; i++) {
                output += " ";
            }
            if (additionalWhiteSpaces > 0) {
                output += " ";
                additionalWhiteSpaces--;
            }
        }
        return output.trim(); //any trailing white spaces are removed
    }

    /*
     * driver program
     */
    public static void main(String[] args) throws Exception {
        String input = "The quick brown fox jumps over the lazy dog.";
        int size = 52;
        System.out.println(input);
        System.out.println(justify(input, size));
    }
}
