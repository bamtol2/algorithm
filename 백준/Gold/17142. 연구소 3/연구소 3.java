import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;   // 최소 시간 저장

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 병원 좌표 모음
    static List<int[]> hospitals = new ArrayList<>();
    // 선택된 병원 좌표 저장
    static int[][] selected;
    static int hospitalCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        // 입력 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    hospitals.add(new int[]{i, j}); // 병원 좌표 저장
                }
            }
        }

        hospitalCount = hospitals.size();
        selected = new int[M][2];

        // 병원 M개 조합 선택
        comb(0, 0);

        // 출력 (불가능하면 -1)
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // 병원 M개를 고르는 조합
    static void comb(int depth, int start) {
        if (depth == M) {
            simulate();
            return;
        }
        for (int i = start; i < hospitalCount; i++) {
            int[] pos = hospitals.get(i);
            selected[depth][0] = pos[0];
            selected[depth][1] = pos[1];
            comb(depth + 1, i + 1);
        }
    }

    // BFS로 동시에 퍼뜨리기
    static void simulate() {
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dist = new int[N][N];

        // dist 초기화 (-1은 아직 도달하지 못함)
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 선택된 병원들을 시작점으로 큐에 넣음
        for (int i = 0; i < M; i++) {
            int x = selected[i][0];
            int y = selected[i][1];
            dq.addLast(new int[]{x, y});
            dist[x][y] = 0; // 시작은 0초
        }

        // BFS 시작
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 맵 범위 벗어나면 패스
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 벽(1)은 통과 불가
                if (map[nx][ny] == 1) continue;

                // 이미 방문한 곳은 패스
                if (dist[nx][ny] != -1) continue;

                // 현재 시각 + 1 로 기록
                dist[nx][ny] = dist[x][y] + 1;

                // 큐에 추가
                dq.addLast(new int[]{nx, ny});
            }
        }

        // BFS 끝난 후, 모든 바이러스(0)가 퍼졌는지 확인
        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) continue; // 벽은 무시
                if (map[i][j] == 0) {         // 바이러스 칸만 확인
                    if (dist[i][j] == -1) {
                        return; // 도달 못한 바이러스 있으면 실패
                    }
                    time = Math.max(time, dist[i][j]); // 가장 늦게 퍼진 시간 기록
                }
            }
        }

        // 최소 시간 갱신
        answer = Math.min(answer, time);
    }
}