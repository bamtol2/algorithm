import java.util.*;
import java.io.*;

public class Main {
    static int M, N, H;
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[][][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();

        // 입력 + 시작점(1) 전부 큐에 넣기
        for (int h = 0; h < H; h++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[h][y][x] = Integer.parseInt(st.nextToken());
                    if (box[h][y][x] == 1) {
                        q.add(new int[]{h, y, x});
                    }
                }
            }
        }

        bfs(q);

        // 결과 계산
        int max = 1;
        for (int h = 0; h < H; h++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[h][y][x] == 0) { // 끝까지 안 익은 토마토 존재
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, box[h][y][x]);
                }
            }
        }

        // 처음부터 다 익어있으면 max=1 -> 0일
        System.out.println(max - 1);
    }

    static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int h = now[0];
            int y = now[1];
            int x = now[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 범위 체크
                if (nh < 0 || nh >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                // 안 익은 토마토(0)만 익히기
                if (box[nh][ny][nx] == 0) {
                    box[nh][ny][nx] = box[h][y][x] + 1; // 날짜 누적
                    q.add(new int[]{nh, ny, nx});
                }
            }
        }
    }
}
