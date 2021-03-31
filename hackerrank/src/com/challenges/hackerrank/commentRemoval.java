/*
  question link : https://www.hackerrank.com/challenges/ide-identifying-comments/problem
*/

package com.challenges.hackerrank;

import java.util.Scanner;

public class commentRemoval {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        boolean trigger = false;
        while (in.hasNext()) {
            String input = in.nextLine();
            //System.out.println("input : "+input);
            input = input.trim();
            if ((input.startsWith("//")) || (input.startsWith("/*") && input.endsWith("*/"))) {
                System.out.println(input);
            }
            else if (input.startsWith("/*") && !input.endsWith("*/")) {
                System.out.println(input);
                trigger = true;
            }
            else if (input.endsWith("*/") && !input.startsWith("/*")) {
                System.out.println(input);
                trigger = false;
            }
            else if (trigger == true) {
                System.out.println(input);
            }
            else if (input.contains("//")) {
                int slashIndex = input.indexOf("//");
                System.out.println(input.substring(slashIndex, input.length()));
            }
        }
    }
}
