import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        int result = 1;
        
        for (String[] item : clothes) {
            String name = item[0];
            String type = item[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for (String[] item : clothes){
            String type = item[1];
            
            set.add(type);
        }
        
        for (String s : set){
            int a = map.get(s) + 1;
            result *= a;
        }
        result -= 1;
        return result;
    }
}