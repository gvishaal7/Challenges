/*
 * question link: https://leetcode.com/problems/license-key-formatting/
 */
package com.challenges.leetcode;

public class License_Key_Formatting {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        char[] sArray = S.toCharArray();
        String output = "";
        int counter = 0;
        for (int i = sArray.length - 1; i >= 0; i--) {
            if ((counter) % K == 0 && counter != 0) {
                counter = 0;
                output = "-" + output;
            }
            if (sArray[i] >= 97 && sArray[i] <= 122) {
                sArray[i] -= 32;
            }
            output = sArray[i] + output;
            counter++;
        }
        return output;
    }
}
