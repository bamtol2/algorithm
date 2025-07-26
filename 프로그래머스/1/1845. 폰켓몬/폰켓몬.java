import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int choose = nums.length / 2;
        
        for(Integer n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        
        if (keyList.size() > choose){
            return choose;
        } else {
            return keyList.size();
        }
    }
}