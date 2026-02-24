import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        if (map.size() == 1) { // 모두 같음
            int p = a;
            return 1111 * p;
        }
        
        if (map.size() == 2) {
            int p = 0, q = 0;
            for (int key : map.keySet()) {
                if (map.get(key) == 3) p = key;
                else q = key;
            }
            if (p != 0) { // 3개 같음
                return (int)Math.pow(10 * p + q, 2);
            } else { // 2개씩 같음
                Iterator<Integer> it = map.keySet().iterator();
                p = it.next();
                q = it.next();
                return (p + q) * Math.abs(p - q);
            }
        }
        
        if (map.size() == 3) { // 하나만 쌍
            int p = 0, q = 1, r = 1;
            for (int key : map.keySet()) {
                if (map.get(key) == 2) p = key;
            }
            List<Integer> list = new ArrayList<>();
            for (int key : map.keySet()) {
                if (key != p) list.add(key);
            }
            return list.get(0) * list.get(1);
        }
        
        // 모두 다름
        return Math.min(Math.min(a, b), Math.min(c, d));
    }
}