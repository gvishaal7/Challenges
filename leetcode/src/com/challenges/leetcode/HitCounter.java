package com.challenges.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class HitCounter {

    Map<Integer,Integer> counterMap;
    int size;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        this.size = 0;
        this.counterMap = new ConcurrentHashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        flush(timestamp);
        int val = counterMap.getOrDefault(timestamp,0);
        val++;
        counterMap.put(timestamp, val);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        flush(timestamp);
        return size;
    }
    
    private void flush(int timestamp) {
        this.size = 0;
        for(Map.Entry<Integer,Integer> counter : counterMap.entrySet()) {
            if(counter.getKey() <= (timestamp - 300)) {
                counterMap.remove(counter.getKey());
            }
            size += counterMap.getOrDefault(counter.getKey(),0);
        }
    }
    
    
    public static void main(String[] args) {
    	String r = "1asda";
    	List<Integer> li = new ArrayList<>();
    	
    	System.out.println("str: "+r.substring(0,0));
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
