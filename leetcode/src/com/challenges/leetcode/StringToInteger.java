/*
 * question link : https://leetcode.com/problems/string-to-integer-atoi/description/
 */

package com.challenges.leetcode;

import java.math.BigInteger;

class StringToInteger {
    public int myAtoi(String str) {
        int output = 0;
        if (str != null && !str.isEmpty()) {
            str = str.trim();
            if (!str.equals("") && !str.isEmpty()) {
                char[] strArray = str.toCharArray();
                String tempStr = "";
                if (!Character.isDigit(strArray[0]) && strArray[0] != '-' && strArray[0] != '+') {
                    return 0;
                }
                else {
                    tempStr += strArray[0];
                }
                for (int i = 1; i < strArray.length; i++) {
                    if (Character.isDigit(strArray[i])) {
                        tempStr += strArray[i];
                    }
                    else {
                        break;
                    }
                }
                if (tempStr.length() == 1) {
                    if (tempStr.charAt(0) == '-' || tempStr.charAt(0) == '+') {
                        return 0;
                    }
                    else {
                        return Integer.parseInt(tempStr);
                    }
                }
                if (tempStr.charAt(0) == '+') {
                    tempStr = tempStr.substring(1, tempStr.length());
                }
                BigInteger number = new BigInteger(tempStr);
                if (number.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) == -1) {
                    return Integer.MIN_VALUE;
                }
                else if (number.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) == 1) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.parseInt(tempStr);
                }
            }
        }
        return output;
    }
}
