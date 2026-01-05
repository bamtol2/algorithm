import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for (int j = 1; j <= M; j++){
                // charAt()의 결과는 문자(Char) 숫자로 쓰려면 - '0'
                map[i][j] = line.charAt(j-1) - '0';
            }
        }

        int answer = bfs(1,1);
        System.out.println(answer);
    }

    static int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int i = 0; i < 4; i++){
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if(ny > 0 && nx > 0 && ny <= N && nx <= M && !visited[ny][nx] && map[ny][nx] == 1){
                    map[ny][nx] = map[nowY][nowX] + 1;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                }
            }
        }
        return map[N][M];
    }
}
