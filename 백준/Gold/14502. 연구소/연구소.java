import java.util.*;
import java.io.*;

// 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야한다
// 0 : 빈칸, 1 : 벽, 2 : 바이러스
// 안전 영역의 크리의 최댓값

public class Main {
	static int N; // 세로
	static int M; // 가로
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static int[][] copyMap;

	// 바이러스 위치를 저장
	static Deque<virus> deque = new LinkedList<>();

	// 최대 안전 영역 크기를 저장할 변수
	static int maxSafetyRoom = Integer.MIN_VALUE;

	// 바이러스의 위치를 저장하는 클래스
	static class virus {
		int x;
		int y;

		public virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// DFS를 사용하여 벽 3개를 세우는 모든 경우의 수 탐색
		dfs(0);

		System.out.println(maxSafetyRoom);
	}

	// dfs 를 사용해 벽 세우기
	public static void dfs(int wall) {
		// 벽 3개를 모두 세운 경우
		if (wall == 3) {
			bfs(); // bfs를 통해서 바이러스 전파 확인
			return;
		}

		// 빈 공간에 벽을 세우는 모든 경우의 수를 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 빈 공간인 경우
					map[i][j] = 1; // 벽을 세움
					dfs(wall + 1); // 재귀적으로 다음 벽을 세움
					map[i][j] = 0; // 벽을 허물고 다음 경우의 수를 탐색
				}
			}
		}
	}

	// bfs를 이용하여 바이러스를 전파 확인
	public static void bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) { // 바이러스가 있는 위치
					deque.add(new virus(i, j)); // 덱에 추가
				}
			}
		}

		copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}

		// 지도의 복사본 생성
		while (!deque.isEmpty()) {
			virus v = deque.remove(); // 큐에서 바이러스 위치를 하나 꺼냄

			// 바이러스 전파
			for (int i = 0; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];

				// 지도 내에 있고 빈 공간인 경우
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (copyMap[nx][ny] == 0) {
						copyMap[nx][ny] = 2; // 바이러스를 전파
						deque.add(new virus(nx, ny)); // 전파된 위치를 덱에 추가
					}
				}
			}
		}
		// 안전 영역 크기 계산
		calSafeZone(copyMap);
	}

	// 복사된 지도에서 안전 영역(0의 개수) 를 계산하는 함수
	public static void calSafeZone(int[][] copyMap) {
		int safeZone = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					safeZone++;
				}
			}
		}
		maxSafetyRoom = Math.max(safeZone, maxSafetyRoom);
	}
}
