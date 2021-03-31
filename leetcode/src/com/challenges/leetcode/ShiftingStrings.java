package com.challenges.leetcode;

import java.util.*;

public class ShiftingStrings {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> as = new PriorityQueue<>(5);
        as.add(4);
        as.add(1);
        as.add(3);
        as.add(5);
        as.add(2);
        as.add(6);
        as.add(7);
        System.out.println("before poll: " + as);
        as.poll();
        System.out.println("after  poll: " + as);
        List<Integer> r = new ArrayList<>(5);
        String s = "as";

        String[] asd1 = new String[4];
        //"Keep calm and code on";
        String ip = "Keep calm and code on";
        asd1 = ip.toLowerCase().split(" ");
        System.out.println(Arrays.toString(asd1));
        Arrays.sort(asd1, new Comparator<String>() {

            @Override public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }

        });
        System.out.println(Arrays.toString(asd1));
    }

    public String stringShift(String s, int[][] shift) {
        int[] shiftSum = new int[2];
        for (int i = 0; i < shift.length; i++) {
            int dir = shift[i][0];
            int val = shift[i][1];
            shiftSum[dir] += val;
        }

        int diff = shiftSum[0] - shiftSum[1];
        diff = (diff % s.length());
        if (diff == 0) {
            return s;
        }
        else if (diff > 0) {
            return shiftLeft(s.toCharArray(), diff);
        }
        else {
            diff *= (-1);
            return shiftRight(s.toCharArray(), diff);
        }

    }

    /*
     1 2 3 4 5
     5 1 2 3 4
    */
    private String shiftLeft(char[] sArray, int diff) {
        char[] output = new char[sArray.length];
        int j = 0;
        for (int i = diff; i < sArray.length; i++, j++) {
            output[j] = sArray[i];
        }
        for (int i = 0; i < diff; i++, j++) {
            output[j] = sArray[i];
        }
        return new String(output);
    }

    private String shiftRight(char[] sArray, int diff) {
        char[] output = new char[sArray.length];
        int j = 0;
        for (int i = diff; i < sArray.length; i++, j++) {
            output[i] = sArray[j];
        }
        for (int i = 0; i < diff; i++, j++) {
            output[i] = sArray[j];
        }
        return new String(output);
    }
}
