import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        
        for (int n : arr) {
            if (set.size() == k) break;
            set.add(n);
        }
        
        int[] answer = new int[k];
        int idx = 0;
        
        for (int n : set) {
            answer[idx++] = n;
        }
        
        while (idx < k) {
            answer[idx++] = -1;
        }
        
        return answer;
    }
}
