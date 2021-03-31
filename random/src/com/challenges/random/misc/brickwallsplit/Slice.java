package com.challenges.random.misc.brickwallsplit;

import java.util.ArrayList;
import java.util.HashMap;

public class Slice {

    public static ArrayList<Integer> getSlice(Wall w) {
        int index = -1;
        int length = w.length;
        //each slice is mapped with the number of bricks broken
        HashMap<Integer, Integer> sliceMap = new HashMap<>();
        for (int slice = 1; slice <= length - 1; slice++) { //for every slice from 1 - n-1
            int count = 0;
            for (int i = 0; i < w.height; i++) { //for each level
                Level level = w.level[i];
                int sum = 0;
                for (int j = 0; j < level.bricks; j++) { //for each brick
                    sum += level.length[j];
                    /*
                        the bricks in each level are added together.
                        when the current slice is less than the sum at a given level, then it breaks a brick
                        if its equal, then we can get equal parts without breaking any brick in that level.
                    */
                    if (sum >= slice) {
                        if (sum > slice)
                            count++;
                        break;
                    }
                }
            }
            sliceMap.put(slice, count);
        }
        int min = Integer.MAX_VALUE;
        for (Integer i : sliceMap.keySet()) {
            if (sliceMap.get(i) < min) {
                index = i; //slice with the least broken bricks is picked
                min = sliceMap.get(i);
            }
        }
        //if there is more than one slice that gives the minimus bricks broken, then they are returned as well.
        ArrayList<Integer> minList = new ArrayList<>();
        for (Integer i : sliceMap.keySet()) {
            if (sliceMap.get(i) == min) {
                minList.add(i);
            }
        }
        return minList;
    }
}
