import java.util.*;
import java.io.*;

public class Main {
    static int N,M,loaf,years;
    static int[][] map,decrease;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        years = 0;
        map = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                }
        }

        while(true){
            loaf = 0; // 빙산의 개수는 매년 새로 계산
            visited = new boolean[N][M];
            decrease = new int[N][M];
            // 1. 감소 카운트 저장
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] > 0){
                        decreaseCount(i,j);
                    }
                }
            }

            // 2. 감소
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    int count = map[i][j] - decrease[i][j];
                    // (count가 >= 0 이면 반영)
                    if (count <= 0){
                        map[i][j] = 0;
                    } else {
                        map[i][j] = count;
                    }
                }
            }

            years ++;

            // 3. 탐색하면서 덩어리 찾기
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    // 방문하지 않았고, > 0 이면 bfs시작
                    if (!visited[i][j] && map[i][j] > 0){
                        bfs(i,j);
                        loaf ++; // 덩어리 추가
                    }
                }
            }

            if (loaf >= 2){
                System.out.println(years);
                break;
            } else if (loaf == 0) {
                System.out.println(0);
                break;
            }
        }
    }
    static void decreaseCount(int y, int x){
        // 4방향 탐색하면서 decrease 배열에 뺴야할 수 추가
        for (int t = 0; t < 4; t++){
            int ny = y + dy[t];
            int nx = x + dx[t];
            // 범위를 벗어나면 contunue
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            // 만약 바닷가(==0) 이면 +1 증가
            if (map[ny][nx] == 0){
                decrease[y][x] ++;
            }
        }
    }

    static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                // 방문했으면 continue;
                if (visited[ny][nx]) continue;
                // 0 이면 continue
                if (map[ny][nx] == 0) continue;

                q.add(new int[]{ny,nx});
                visited[ny][nx] = true;
            }
        }
    }
}
