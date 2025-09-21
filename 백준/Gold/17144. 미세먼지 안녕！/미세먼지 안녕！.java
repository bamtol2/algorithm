import java.io.*;
import java.util.*;

public class Main {
	static int N,M,T;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		// 시공의 돌풍 -1 표시, 항상 맨 왼쪽 위치, 두 칸 차지(맨 윗행과 맨 아랫 행과 적어도 두 칸 이상 떨어짐)
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < T; i++) {
			simulate();
		}
		
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					sum += map[i][j];
				}
			}
		}
		
		System.out.println(sum);
		
	}
	
	static void simulate() {
		// 1. 먼지확산
		spread();
		// 2. 돌풍 청소
		clean();
	}
	
	// [1] 먼지 확산
	static void spread() {
		int[][] newMap = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 해당 칸에 돌풍이 있으면
				if(map[i][j] == -1) {
					newMap[i][j] = -1;
					continue;
				}
				
				if(map[i][j] > 0) {
					int spreadAmount = map[i][j]/5;
					int cnt = 0;
					
					// 인접한 4방향 탐색
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						// 시공의 돌풍이 있거나 방의 범위를 벗어나면 continue
						if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1) continue;
						
						// 확산을 하면 확산됀 새로운곳에 더해주고
						newMap[nx][ny] += spreadAmount;
						cnt++;
					}
				map[i][j] -= spreadAmount * cnt;
				}
			}
		}
		// 확산된 먼지(newMap)는 모든 먼지가 확산을 끝낸 다음 해당 칸에 더해짐
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] >= 0) {
					map[i][j] += newMap[i][j];
				}
			
			}
		}
	}
	
	// [2] 돌풍이 청소 시작
	static void clean() {
		// 1. 돌풍 위치 찾기
		int top = -1, bottom = -1;
		for (int i = 0; i < N; i++) {
			if (map[i][0] == -1) {
				top = i;
				bottom = i+1;
				break;
			}
		}
		
		// 2. 위쪽 반시계 순환
		for (int i = top - 1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for (int i = 0; i < M-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for(int i = 0; i < top; i++) {
			map[i][M-1] = map[i+1][M-1];
		}
		for (int i = M-1; i > 1; i--) {
			map[top][i] = map[top][i-1];
		}
		map[top][1] = 0;
		// 3. 아래쪽 시계 순환
		for(int i = bottom + 1; i < N-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for (int i = 0; i < M-1; i++) {
			map[N-1][i] = map[N-1][i+1];
		}
		for(int i = N-1; i > bottom; i--) {
			map[i][M-1] = map[i-1][M-1];
		}
		for (int i = M-1; i > 1; i--) {
			map[bottom][i] = map[bottom][i-1];
		}
		map[bottom][1] = 0;
	}
}
