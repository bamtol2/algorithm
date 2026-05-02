import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];
        double[] avg = new double[n];

        // 1. 평균 계산
        for (int i = 0; i < n; i++) {
            avg[i] = (score[i][0] + score[i][1]) / 2.0;
        }

        // 2. 정렬용 배열 복사
        double[] sorted = avg.clone();
        Arrays.sort(sorted);

        // 3. 내림차순 기준으로 등수 매기기
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (avg[i] == sorted[j]) {
                    answer[i] = n - j;
                    break;
                }
            }
        }

        return answer;
    }
}