/*
 * question link: https://leetcode.com/problems/unique-morse-code-words/
 *
 */

package com.challenges.leetcode;

import java.util.HashMap;
import java.util.Map;

class UniqueMorseCode {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        Map<String, Integer> transCount = new HashMap<>();
        for (String word : words) {
            char[] wordArray = word.toCharArray();
            String transWord = "";
            for (int i = 0; i < wordArray.length; i++) {
                transWord += morseCodes[wordArray[i] - 97];
            }
            if (!transCount.containsKey(transWord)) {
                transCount.put(transWord, 1);
            }
        }
        return transCount.size();
    }
}
