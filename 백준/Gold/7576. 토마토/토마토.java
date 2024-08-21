import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    // 익은 토마토(1)의 좌표를 큐에 저장
                    q.add(new int[]{i, j});
                }
            }
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        int ans = 0;
        for (int[] line : arr) {
            for (int tomato : line) {
                if (tomato == 0) {
                    // 안익은 토마토(0)이 있으면 바로 정지
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, tomato);
            }
        }
        // 1에서 시작했기 때문에 결과 값에서 1빼주기
        System.out.println(ans - 1);
    }
}