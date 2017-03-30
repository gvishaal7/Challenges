/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenges;

import java.util.*;

/**
 *
 * @author vishaalgopalan
 */
public class testclass {
        public static void main(String[] args) {         
            int sum = 0;
            int first = 1;
            int last = 1000;
            while(first<last) {
                if(first%3==0 || first%5==0){
                    sum += first;
                }
                if(last%3==0 || last%5==0) {
                    sum += last;
                }
                first++;
                last--;                
            }           
            System.out.println("sum1 : "+sum);
        }
}