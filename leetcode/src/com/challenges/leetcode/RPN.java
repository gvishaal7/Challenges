/*
 * question: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
package com.challenges.leetcode;

import java.util.Stack;

public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "/".equals(tokens[i]) || "*".equals(tokens[i])) {
                int num1 = myStack.pop();
                int num2 = myStack.pop();
                myStack.add(evaluate(num2, num1, tokens[i]));
            }
            else {
                myStack.add(Integer.parseInt(tokens[i]));
            }
        }
        return myStack.pop();
    }

    private int evaluate(int num1, int num2, String oper) {
        switch (oper) {
        case "+":
            return (num1 + num2);
        case "-":
            return (num1 - num2);
        case "*":
            return (num1 * num2);
        case "/":
            return (num1 / num2);
        }
        return 0;
    }
}
