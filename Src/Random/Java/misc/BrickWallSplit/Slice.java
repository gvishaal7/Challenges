package brickwallsplit;

import java.util.ArrayList;
import java.util.HashMap;

public class Slice {
    
    public static ArrayList<Integer> getSlice(Wall w) {
        int index = -1;
        int length = w.length;
        HashMap<Integer,Integer> sliceMap = new HashMap<>();
        for(int slice=1;slice<=length-1;slice++) {
            int count = 0;
            for(int i=0;i<w.height;i++) {
                Level level = w.level[i];
                int sum = 0;
                for(int j=0;j<level.bricks;j++) {
                    sum += level.length[j];
                    if(sum >= slice) {
                        if(sum > slice) 
                            count++;
                        break;
                    }
                }
            }
            sliceMap.put(slice, count);
        }
        int min = Integer.MAX_VALUE;
        for(Integer i : sliceMap.keySet()) {
            if(sliceMap.get(i) < min) {
                index = i;
                min = sliceMap.get(i);
            }            
        }    
        ArrayList<Integer> minList = new ArrayList<>();
        for(Integer i : sliceMap.keySet()) {
            if(sliceMap.get(i) == min) {
                minList.add(i);
            }
        }
        return minList;
    }
}
