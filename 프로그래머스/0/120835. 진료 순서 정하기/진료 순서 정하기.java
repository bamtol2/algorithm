import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] answer = new int[n];
        int[] sorted = emergency.clone();
        
        Arrays.sort(sorted);
        
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            rankMap.put(sorted[i], rank++);
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = rankMap.get(emergency[i]);
        }
        
        return answer;
    }
}