import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 바위 위치 정렬 (순서대로 비교하려면 필수)
        Arrays.sort(rocks);

        int left = 1;               // 최소 거리의 최솟값
        int right = distance;       // 최소 거리의 최댓값
        int answer = 0;             // 정답: 최소 거리의 최댓값

        // 이분탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2;  // 최소 거리 후보

            int prev = 0;                  // 이전 바위 또는 시작 지점 (0)
            int removeCount = 0;           // 제거한 바위 수

            // 바위 하나씩 확인
            for (int i = 0; i < rocks.length; i++) {
                int gap = rocks[i] - prev; // 현재 바위와 이전 위치 간 거리

                if (gap < mid) {
                    // 거리가 너무 가까우면 바위 제거
                    removeCount++;
                } else {
                    // 거리가 충분하므로 prev 갱신
                    prev = rocks[i];
                }
            }

            // 마지막 바위와 도착지점 사이 거리 확인
            if (distance - prev < mid) {
                removeCount++;
            }

            // 제거한 바위 수가 n 이하이면 → 현재 mid는 가능한 거리
            if (removeCount <= n) {
                answer = mid;          // mid를 답으로 저장
                left = mid + 1;        // 더 큰 거리 도전
            } else {
                right = mid - 1;       // 거리가 너무 크다 → 줄이기
            }
        }

        return answer;
    }
}