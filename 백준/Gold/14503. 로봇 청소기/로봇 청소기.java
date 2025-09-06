import java.io.*;
import java.util.*;

public class Main {
    static int N, M, x, y, d;
    static int[][] map;            // 0: 빈 칸, 1: 벽
    static boolean[][] visited;    // 청소 여부
    // d: 0 상, 1 우, 2 하, 3 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // 0상 1우 2하 3좌

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int area = simulate();
        System.out.println(area);
    }

    public static int simulate() {
        int count = 0;

        while (true) {
            // 1. 현재 칸 청소
            if (!visited[x][y]) {
                visited[x][y] = true;
                count++;
            }

            // 2. 주변 4칸 중 미청소 빈 칸 탐색
            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                // 반시계 90도 회전: 상->좌, 우->상, 하->우, 좌->하
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 빈 칸이면서 아직 청소하지 않은 경우 전진
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    x = nx;
                    y = ny;
                    moved = true;
                    break; // 1번으로
                }
            }
            if (moved) continue;

            // 3. 네 방향 모두 없으면 뒤로 한 칸 후진
            int bx = x - dx[d];
            int by = y - dy[d];

            // 뒤가 벽이면 종료
            if (map[bx][by] == 1) {
                break;
            } else {
                x = bx;
                y = by; // 방향은 유지
            }
        }

        return count;
    }
}