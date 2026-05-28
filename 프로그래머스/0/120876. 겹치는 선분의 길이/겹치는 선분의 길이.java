class Solution {
    public int solution(int[][] lines) {
        int answer = 0;

        // 좌표 범위가 -100 ~ 100 이므로 충분히 크게 배열 생성
        int[] count = new int[201];

        // 각 선분이 지나가는 구간 체크
        for (int[] line : lines) {
            int start = line[0];
            int end = line[1];

            for (int i = start; i < end; i++) {
                count[i + 100]++;
            }
        }

        // 2개 이상 겹치는 구간 길이 계산
        for (int c : count) {
            if (c >= 2) {
                answer++;
            }
        }

        return answer;
    }
}