import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] move = {-1, 1, 2};
    static int[] count;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count = new int[100001];
        Arrays.fill(count, -1);   // 방문 안 한 상태

        count[N] = 0;             // 시작 위치: 이동 0번
        q.add(N);

        bfs();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) {
                System.out.println(count[now]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) {
                    next = now * move[i];
                } else {
                    next = now + move[i];
                }

                // 범위 체크
                if (next < 0 || next >= 100001) continue;

                // 방문 안 한 곳이면
                if (count[next] == -1) {
                    count[next] = count[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}