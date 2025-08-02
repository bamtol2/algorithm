import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int a = citations.length;
        
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= a) return a;
            else a--;
        }
        return 0;
    }
}