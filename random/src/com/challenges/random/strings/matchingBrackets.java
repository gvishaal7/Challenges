/*
Question : show if the given strings have balanced or un-balanced brackets
example : 
{[()]} -> balanced
{()[()]} -> balanced
{[(])} -> un-balanced

We say a sequence of brackets is balanced if the following conditions are met:
1) It contains no unmatched brackets.
2) The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
*/

package com.challenges.random.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class matchingBrackets {
  public static boolean isBalanced(String expression) {
        boolean is_balanced= false;
        try {
            int exp_length = expression.length();
            List<Character> bracketList = new ArrayList<Character>();
            if(exp_length%2 ==0) {
                for(int index=0;index<exp_length;index++) {
                    char currentBracket = expression.charAt(index);
                    if(currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                        bracketList.add(currentBracket);
                    }
                    else if(currentBracket == ')') {
                        char lastItemFromList = bracketList.get(bracketList.size()-1);
                        if(lastItemFromList == '(') {
                            bracketList.remove(bracketList.size()-1);
                        }
                    }
                    else if(currentBracket == ']') {
                        char lastItemFromList = bracketList.get(bracketList.size()-1);
                        if(lastItemFromList == '[') {
                            bracketList.remove(bracketList.size()-1);
                        }
                    }
                    else if(currentBracket == '}') {
                        char lastItemFromList = bracketList.get(bracketList.size()-1);
                        if(lastItemFromList == '{') {
                            bracketList.remove(bracketList.size()-1);
                        }
                    }
                }
                if(bracketList.isEmpty()) {
                    is_balanced = true;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return is_balanced;
    }
  
    public static void main(String[] args) {
        Scanner in = null;
        try{
          String expression = "";
          do {
              expression = in.next();
              if(!expression.equals("0")) {
                System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
              }
          } while(!expression.equals("0")); //keeps getting expression until 0 is entered
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
          try {
            if(in!=null) { in.close(); }
          } catch(Exception e) {
            e.printStackTrace();
          }
        }
    }
}
