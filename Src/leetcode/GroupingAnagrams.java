import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupingAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            char[] currArray = strs[i].toCharArray();
            Arrays.sort(currArray);
            String tempStr = new String(currArray);
            List<String> temp = map.getOrDefault(tempStr, new ArrayList<>());
            temp.add(strs[i]);
            map.put(tempStr,temp);        
            List<Integer> s = new ArrayList<>();
            s.sort((a,b) -> {
            	if(a>b) return a; else return b;
            	});
        } 
        List<List<String>> output = new ArrayList<>(map.values());
        return output;
    }
    
    public static void main(String[] args) {
    	int[] asrq = new int[2];
    	List<Integer> temp = Arrays.asList(asrq);
    	temp.add(1);
    	temp.add(3);
    	temp.add(2);    	
    	System.out.println("before sorting: "+temp);
    	temp.sort(null);
    	System.out.println("after sorting: "+temp);
    }
}