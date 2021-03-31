package com.challenges.leetcode;

/*
 * question link: https://leetcode.com/problems/open-the-lock/
 */

import java.util.*;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        String start = "0000";
        int times = -1;
        Set<String> alreadySeen = new HashSet<>();
        Set<String> deadList = new HashSet<>(Arrays.asList(deadends));
        Queue<Map> myQue = new LinkedList<>();
        Map<String,Integer> tempMap = new HashMap<>();
        tempMap.put(start,0);
        if(!deadList.contains(start)) {
            myQue.add(tempMap);
            alreadySeen.add(start);
        }
        while(!myQue.isEmpty()) {
            Map<String,Integer> first = myQue.poll();
            String currStr = first.keySet().iterator().next();
            int currVal = first.get(currStr);
            if(currStr.equals(target)) {
                times = currVal;
                break;
            }
            currVal++;
            for(int pos=0;pos<4;pos++)
            {
                String positiveTurn = rotate(currStr,pos,true);
                String negativeTurn = rotate(currStr,pos,false);

                tempMap = new HashMap<>();
                tempMap.put(positiveTurn,currVal);
                if(!deadList.contains(positiveTurn) && !alreadySeen.contains(positiveTurn)) {
                    myQue.add(tempMap);
                    alreadySeen.add(positiveTurn);
                }

                tempMap = new HashMap<>();
                tempMap.put(negativeTurn, currVal);
                if(!deadList.contains(negativeTurn) && !alreadySeen.contains(negativeTurn)) {
                    myQue.add(tempMap);
                    alreadySeen.add(negativeTurn);
                }
            }
        }
        return times;
    }

    private String rotate(String current, int position,boolean add) {
        int val = Integer.parseInt(current.substring(position,position+1));
        if(add) {
            val++;
            if(val > 9) {
                val = 0;
            }
        }
        else {
            val--;
            if(val < 0) {
                val = 9;
            }
        }
        return (current.substring(0,position)+String.valueOf(val)+current.substring(position+1));
    }

}
