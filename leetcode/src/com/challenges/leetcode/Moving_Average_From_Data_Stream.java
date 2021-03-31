/*
 * question link: https://leetcode.com/problems/moving-average-from-data-stream/
 */

package com.challenges.leetcode;

public class Moving_Average_From_Data_Stream {
    private int size;
    private int[] numbers;
    private int index;
    private boolean isMoreThanWindow;

    /**
     * Initialize your data structure here.
     */
    public Moving_Average_From_Data_Stream(int size) {
        this.size = size;
        this.numbers = new int[size];
        this.index = 0;
        this.isMoreThanWindow = false;
    }

    public double next(int val) {
        if (index == size) {
            isMoreThanWindow = true;
            index = 0;
        }
        this.numbers[index] = val;
        index++;
        return average(numbers);
    }

    private double average(int[] numbers) {
        double avg = 0;
        int numberSize = (isMoreThanWindow ? this.size : index);
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        avg = (sum / numberSize);
        return avg;
    }

}
