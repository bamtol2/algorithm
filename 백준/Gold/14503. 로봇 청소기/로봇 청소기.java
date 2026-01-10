import java.io.*;
import java.util.*;

public class Main {
    static int N,M,r,c,d;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] map;
    static boolean[][] cleaned;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = simulate(r,c,d);
        System.out.println(answer);
    }

    static int simulate(int r, int c, int d){
        int sum = 0;

        while(true){
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다
            if (!cleaned[r][c]){
                cleaned[r][c] = true;
                sum ++;
            }

            boolean moved = false;

            // 2. 현재 칸 주변4칸 중 청소되지 않은 빈 칸이 있는 경우
            for (int i = 0; i < 4; i++){
                d = (d + 3) % 4;
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한칸 전진
                int ny = r + dy[d];
                int nx = c + dx[d];
                // 방문 안했고 청소 안했으면
                if (!cleaned[ny][nx] && map[ny][nx] != 1){
                    r = ny;
                    c = nx;
                    moved = true;
                    break;
                }
            }

            // 움직였으면 continue
            if(moved) continue;

            // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸을 유지하고 1번으로
            int back = (d+2) % 4;
            int by = r + dy[back];
            int bx = c + dx[back];

            if (map[by][bx] == 1){
                break;
            } else {
                r = by;
                c = bx;
            }

        }
        return sum;
    }
}
