/*

  question link : https://leetcode.com/problems/complex-number-multiplication/description/
 
  (a+bi)x(c+di) = ac + adi + bci + bd(-1) | i = sqrt(-1)
  
*/

package com.challenges.leetcode;

class complex_number_multiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] aParts = new String[2];
        String[] bParts = new String[2];
        if (a.contains("+")) {
            aParts[0] = a.substring(0, a.indexOf("+"));
            aParts[1] = a.substring(a.indexOf("+") + 1, a.length());
        }
        if (b.contains("+")) {
            bParts[0] = b.substring(0, b.indexOf("+"));
            bParts[1] = b.substring(b.indexOf("+") + 1, b.length());
        }
        int first = Integer.parseInt(aParts[0]);
        int second = Integer.parseInt(aParts[1].substring(0, aParts[1].length() - 1));
        int third = Integer.parseInt(bParts[0]);
        int fourth = Integer.parseInt(bParts[1].substring(0, bParts[1].length() - 1));
        int temp1 = first * third;
        int temp2 = (first * fourth) + (second * third);
        int temp3 = second * fourth * (-1);
        int temp4 = temp1 + temp3;
        String output = String.valueOf(temp4) + "+";
        output += String.valueOf(temp2) + "i";
        return output;
    }
}
