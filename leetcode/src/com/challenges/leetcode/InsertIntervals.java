/*
 question link : https://leetcode.com/problems/insert-interval/description/
*/

package com.challenges.leetcode;

import java.util.ArrayList;
import java.util.List;

class InsertIntervals {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> intervalList = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;
        int newStart = 0;
        int newEnd = 0;
        if (intervals.isEmpty()) { //base condition to check if intervals list is empty
            intervalList.add(new Interval(start, end));
            return intervalList;
        }
        Interval first = intervals.get(0);
        Interval last = intervals.get(intervals.size() - 1);
        /*
            condition to check if the newInterval is within the range of the intervals.
            since the intervals in 'intervals' list is sorted based on start time,
            we need to check the first and the last intervals to see if the new interval
            lies within the range.
        */
        if (end < first.start || start > last.end) {
            intervalList = intervals;
            /*
                if the new interval is less than the first interval, we add the new
                interval to the begining of the list. if not we add it to the end of the list
            */
            if (end < first.start) {
                intervalList.add(0, new Interval(start, end));
            }
            else {
                intervalList.add(new Interval(start, end));
            }
        }
        else {
            /*
                a flag to check if the new interval lies within any other interval in the list
            */
            boolean insideFlag = false;
            /*
                flags which check if the start and end points of the new boundary is modified or not.
                if it is not modified, then the new interval becomes the new bondary.
            */
            boolean startFlag = false;
            boolean endFlag = false;
            for (int i = 0; i < intervals.size(); i++) {
                Interval currentInterval = intervals.get(i);
                /*
                    condition to check if the new interval is encapsulated by any other interval in the list
                */
                if (start >= currentInterval.start && end <= currentInterval.end) {
                    insideFlag = true;
                    break;
                }
                else {
                    /*
                        condition to check if the new start point lies within any interval in the list.
                        if it lies, then the start point of the interval in which it lies is set as the
                        new start point.
                    */
                    if (currentInterval.start <= start && currentInterval.end >= start) {
                        newStart = currentInterval.start;
                        startFlag = true;
                    }
                    /*
                        condition to check if the new end point lies within any interval in the list.
                        if it lies, then the end point of the interval in which it lies is set as the
                        new end point.
                    */
                    if (currentInterval.end >= end && currentInterval.start <= end) {
                        newEnd = currentInterval.end;
                        endFlag = true;
                    }
                }
            }
            /*
                if the end point in the new interval doesn't lie inside any of the interval in the list,
                then the new end point is set as the new boundary end point.
            */
            if (!endFlag) {
                newEnd = end;
            }
            /*
                if the start point in the new interval doesn't lie inside any of the interval in the list,
                then the new start point is set as the new boundary start point.
            */
            if (!startFlag) {
                newStart = start;
            }
            Interval interval = new Interval(newStart, newEnd);
            if (!insideFlag) {
                /*
                    a flag which makes sure that none of the intervals from the list, which are encapsulated
                    by the new boundary.
                */
                boolean rangeFlag = true;
                for (int i = 0; i < intervals.size(); i++) {
                    Interval current = intervals.get(i);
                    /*
                        a condition which facilitates in adding the new boundary at the right position and prevents
                        adding intervals from the list, that are encapsulated by the new boundary.
                    */
                    if (current.start >= newStart && current.end <= newEnd) {
                        if (rangeFlag) {
                            intervalList.add(interval);
                        }
                        rangeFlag = false;
                    }
                    /*
                        a condition whcih checks if new bondary was not added to the list and it does not encapsulate
                        any other intervals in the list
                        example for the following input,
                        [[1,5],[9,13]]
                        [6,6]
                        the interval [6,6] is added between [1,5] and [9,13] in the following condition.
                    */
                    else if (current.start >= newStart && current.end >= newEnd && rangeFlag) {
                        intervalList.add(interval);
                        intervalList.add(current);
                        rangeFlag = false;
                    }
                    else {
                        intervalList.add(current);
                    }
                }
            }
            else {
                /*
                    if the new interval lies within an interval in the list, then we return the
                    'intervals' without any modification.
                */
                intervalList = intervals;
            }
        }
        return intervalList;
    }

    /* Definition for an interval. */
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
