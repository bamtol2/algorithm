import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 행의 개수
        int m = maps[0].length; // 열의 개수
        
        // 시작점이나 끝점이 막혀있으면 도달 불가
        if (maps[0][0] == 0 || maps[n-1][m-1] == 0){
            return -1;
        }
        
        // 방향 벡터 : 상, 하, 좌, 우
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        // 방문 체크 배열
        boolean[][] visited = new boolean[n][m];
        
        // BFS를 위한 큐 (x좌표, y좌표, 이동거리)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1}); // 시작점 (0,0)에서 거리 1로 시작
        visited[0][0] = true;
        
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            // 목적지에 도달했으면 거리 반환
            if ( x == n-1 && y == m-1){
                return distance;
            }
            
            // 4방향으로 이동 시도
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 경계  체크
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    // 이동 가능하고 방문하지 않은 곳
                    if (maps[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx,ny,distance + 1});
                    }
                }
            }
        }
        // 큐가 비었는데 목적지에 도달 못했으면 -1 반환
        return -1;
    }
}