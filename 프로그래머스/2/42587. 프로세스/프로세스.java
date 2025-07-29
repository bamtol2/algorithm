import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();

        // 큐에 (인덱스, 우선순위) 쌍을 넣음
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        int order = 0; // 실행 순서

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 앞에서 꺼냄

            // 현재보다 우선순위 높은 게 있는지 확인
            boolean hasHigher = false;
            for (int[] q : queue) {
                if (q[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.add(current); // 다시 뒤로 보냄
            } else {
                order++; // 실행됨
                if (current[0] == location) {
                    return order;
                }
            }
        }

        return -1; // 이론적으로 도달 불가능
    }
}
