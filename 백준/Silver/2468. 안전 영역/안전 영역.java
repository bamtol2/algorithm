import java.util.*;
import java.io.*;

public class Main {
    static int N,safeArea;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int height = -1;
        safeArea = -1;

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(map[i][j], height); // 가장 높은 지역
            }
        }

        for (int rain = 0; rain < height; rain++){
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    // 만약 지금 지형이 빗물보다 높고, 방문처리도 안되어있으면
                    if(map[i][j] > rain && !visited[i][j]){
                        q.add(new int[]{i,j});
                        visited[i][j] = true;
                        bfs(rain);
                        cnt += 1;
                    }
                }
            }
            safeArea = Math.max(safeArea,cnt);
        }

        System.out.println(safeArea);
    }
    static void bfs(int rain){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                // 범위 밖에 벗어나면 continue
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] <= rain) continue;

                // 범위 안이면 방문처리 + 큐에 추가 + 빗물보다 높아야함
                visited[ny][nx] = true;
                q.add(new int[]{ny,nx});

            }
        }
    }
}


