/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenges.random.numbers;

/**
 * @author vishaalgopalan
 */
public class multiples {
    public static void main(String[] args) {
        int sum = 0;
        int first = 1;
        int last = 1000;
        while (first < last) {
            if (first % 3 == 0 || first % 5 == 0) {
                sum += first;
            }
            if (last % 3 == 0 || last % 5 == 0) {
                sum += last;
            }
            first++;
            last--;
        }
        System.out.println("sum : " + sum);
                
            /*
            In mathematical terms, when the sum of all digits of a number is a multiple of 3, then the number is a multiple of 3.
            When the last digit of a number is either a 0 or 5, then the number is a multiple of 5.
            Example:
            243 - sum of digits = 9 => is a multiple of 3. since the last digit is 3, it is not a multiple of 5.
            115 - sum of digits = 7 => is not a multiple of 3. since the last digit is 5, it is a multiple of 5.
            330 - sum of digits = 6 => is a multiple of 3. since the last digit is 0, it is a multiple of 5.
            */
    }
}
