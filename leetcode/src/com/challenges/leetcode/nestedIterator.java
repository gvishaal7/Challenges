package com.challenges.leetcode;/*
 * question: https://leetcode.com/problems/flatten-nested-list-iterator/
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class nestedIterator
        implements Iterator<Integer> {

    List<Integer> myList;
    Iterator<Integer> myIter;

    public nestedIterator(List<NestedInteger> nestedList) {
        this.myList = new ArrayList<>();
        flatten(nestedList);
        this.myIter = myList.iterator();
    }

    @Override public Integer next() {
        Integer temp = myIter.next();
        myIter.remove();
        return temp;
    }

    @Override public boolean hasNext() {
        return myIter.hasNext();
    }

    private void flatten(List<NestedInteger> sub) {
        for (NestedInteger ni : sub) {
            if (ni.isInteger()) {
                myList.add(ni.getInteger());
            }
            else {
                flatten(ni.getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
