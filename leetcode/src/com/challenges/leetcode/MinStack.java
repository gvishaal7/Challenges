/*
 * question: https://leetcode.com/problems/min-stack/
 */

package com.challenges.leetcode;

import java.util.Stack;


class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> myStack;
    Stack<Integer> minStack;
    public MinStack() {
        myStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        myStack.add(x);
        if(minStack.isEmpty()) {
            minStack.add(x);
        }
        else {
            int minVal = minStack.peek();
            if(minVal >= x) {
                minStack.add(x);
            }
        }
    }

    public void pop() {
        int val = myStack.pop();
        if(val == minStack.peek()) {
            minStack.pop();
        }

    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
