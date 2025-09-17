import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = k; i <= n; i += k) {
            list.add(i);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
