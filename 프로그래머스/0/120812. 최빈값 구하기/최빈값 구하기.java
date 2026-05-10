import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        // 개수 세기
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int answer = -1;
        boolean duplicated = false;

        for (int key : map.keySet()) {
            int count = map.get(key);

            if (count > max) {
                max = count;
                answer = key;
                duplicated = false;
            } else if (count == max) {
                duplicated = true;
            }
        }

        return duplicated ? -1 : answer;
    }
}