class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        
        // 위험지역 표시용 배열
        boolean[][] danger = new boolean[n][n];
        
        // 8방향 + 자기 자신
        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        
        // 지뢰 기준으로 위험지역 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 9; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        // 범위 체크
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            danger[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
        // 안전지역 개수 세기
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!danger[i][j]) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}