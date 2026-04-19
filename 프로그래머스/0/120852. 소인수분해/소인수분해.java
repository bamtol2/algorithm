import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        
        if (n > 1) {
            list.add(n);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}