import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1][M+1];
        map = new int[N+1][M+1];


        for (int i = 1; i <= N; i++){
            String a = br.readLine();
            for (int j = 1; j <= M; j++){
                map[i][j] = a.charAt(j-1)-'0';
            }
        }

        bfs(1,1);
    }

    static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int i = 0; i < 4; i++){
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                // 범위 안이고
                if(ny > 0 && nx > 0 && ny <= N && nx <= M && !visited[ny][nx] && map[ny][nx] == 1){
                    map[ny][nx] = map[curY][curX] + 1;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                }
            }
        }
        System.out.print(map[N][M]);
    }
}
