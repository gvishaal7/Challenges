/*
    question link : https://leetcode.com/problems/all-oone-data-structure/description/
*/

class AllOne {

    private Map<String,Integer> myMap; //a map to store each key and its count
    private Map<Integer,ArrayList<String>> maxMap; //a map to store the count and all the keys with that count
    /** Initialize your data structure here. */
    public AllOne() {
        myMap = new HashMap<>();
        /*
            tree map is used so that the keys are sorted in the ascending order. This makes retrieving the min
            and max values faster.
        */
        maxMap = new TreeMap<>(); 
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(myMap.containsKey(key)) {
            int count = myMap.get(key); //the count of the 'key' is increased and updated
            count++;
            myMap.put(key,count);
            /*
                the 'key' is now added to a 'new count' in the 'maxMap'
                and is removed from the previous count.
                consider the following example,
                    maxMap = {3=["hello","a"]};
                    inc("a");
                    maxMap = {3=["hello"],4=["a"]}
                from the above example,
                'a' is removed from the key value '3' and is added to key value '4'
            */
            if(maxMap.containsKey(count)) {
                ArrayList<String> tempList = maxMap.get(count);
                tempList.add(key);
                maxMap.put(count,tempList);
            }
            else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(key);
                maxMap.put(count,tempList);
            }
            if(maxMap.containsKey((count-1))) {
                ArrayList<String> tempList = maxMap.get((count-1));
                tempList.remove(key);
                /*
                    if a key has an empty list after removing its last element,
                    then the key is also removed from the 'maxMap'
                */
                if(tempList.isEmpty()) {
                    maxMap.remove((count-1));
                }
                else {
                    maxMap.put((count-1),tempList);
                }
            }
        }
        else {
            myMap.put(key,1);
            if(maxMap.containsKey(1)) {
                ArrayList<String> tempList = maxMap.get(1);
                tempList.add(key);
                maxMap.put(1,tempList);
            }
            else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(key);
                maxMap.put(1,tempList);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(myMap.containsKey(key)) { //the count of 'key' is decreased and updated
            int count = myMap.get(key);
            count--;
            if(count == 0) { 
                /*
                    when the key's value becomes 0, it is removed 'myMap' and also from the list
                    with a key value of '1' in 'maxMap'.
                */
                myMap.remove(key);
                ArrayList<String> tempList = maxMap.get((count+1));
                tempList.remove(key);
                /*
                    if a key has an empty list after removing its last element,
                    then the key is also removed from the 'maxMap'
                */
                if(tempList.isEmpty()) {
                    maxMap.remove((count+1));
                }
                else {
                    maxMap.put((count+1),tempList);
                }
            }
            else {
                myMap.put(key,count);
                ArrayList<String> tempList = maxMap.get((count+1));
                tempList.remove(key);
                /*
                    if a key has an empty list after removing its last element,
                    then the key is also removed from the 'maxMap'
                */
                if(tempList.isEmpty()) {
                    maxMap.remove((count+1));
                }
                else {
                    maxMap.put((count+1),tempList);
                }
                if(maxMap.containsKey(count)) {
                    tempList = maxMap.get(count);
                    tempList.add(key);
                    maxMap.put(count,tempList);
                }
                else {
                    tempList.clear();
                    tempList.add(key);
                    maxMap.put(count,tempList);
                }
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Object[] keys = maxMap.keySet().toArray();
        if(keys.length > 0){
            int lastIndex = (int)keys[keys.length -1]; //the last index/the last key has the max count
            ArrayList<String> tempList = maxMap.get(lastIndex);
            if(tempList != null && !tempList.isEmpty()) {
                return tempList.get(0); //a string with the max value is returned
            }
        }
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Object[] keys = maxMap.keySet().toArray();
        System.out.println(maxMap);
        if(keys.length > 0) {
            int firstIndex = (int)keys[0]; //the first index/the first key has the min count
            ArrayList<String> tempList = maxMap.get(firstIndex);
            if(tempList != null && !tempList.isEmpty()) {
                return tempList.get(0); //a string with the min value is returned
            }
        }
        return "";
    }
    
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
