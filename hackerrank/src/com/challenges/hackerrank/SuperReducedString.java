/*

question link : https://www.hackerrank.com/challenges/reduced-string/problem

*/

package com.challenges.hackerrank;

import java.util.Scanner;

public class SuperReducedString {

    static String super_reduced_string(String s){
        // Complete this function
        if(s == null) {
            return null;
        }
        else {
            int i=0;
            while(!s.equals("") && i != s.length()-1) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    String temp = s.substring(0,i);
                    temp += s.substring(i+2,s.length());
                    s = temp;
                    i=0;
                }
                else {
                    i++;
                }
            }
            if(s.equals("")) {
                s = "Empty String";
            }
            return s;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
