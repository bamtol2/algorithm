import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        // dp 배열 선언
        int[][] dp = new int[n][n];
        
        // 첫 행 초기화
        dp[0][0] = triangle[0][0];
        
        // 두 번째 행부터 dp 채우기
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= i; j++){
                // 가장 왼쪽 경로는 왼쪽 대각선이 없으므로 오른쪽 대각선에서 내려오는 한가지
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i){
                    // 가장 오른쪽 숫자도 바로 위의 오른쪽 대각선이 없으므로, 내려오는 경로는 한가지
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    // 왼쪽 위와 오른쪽 위 대각선 중 큰 값을 골라 현재 값에 더함
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        // 마지막 줄에서 최대값을 찾아 반환
        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, dp[n-1][j]);
        }
        return maxSum;
    }
}