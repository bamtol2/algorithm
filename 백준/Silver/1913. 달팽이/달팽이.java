import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 위 -> 오른쪽 -> 아래 -> 왼쪽
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		// 2차원 배열 생성
		int[][] arr = new int[N][N];
		
		// 시작 위치
		int x = N/2;
		int y = N/2;
		
		// 목표 좌표 저장
		int targetX = 0, targetY = 0;
		
		// 1을 가운데 배치
		arr[x][y] = 1;
		if (target == 1) {
			targetX = x + 1;
			targetY = y + 1;
		}
		
		int num = 2; // 다음에 채울 숫자
		int dir = 0; // 초기 방향 (0: 위)
		int steps = 1; // 현재 방향으로 이동할 칸 수
		
		// 배열 채워나가기
		while(num <= N*N) {
			
			//각 방향으로 steps 만큼 이동 
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < steps && num <= N * N; j++) {
					x += dx[dir];
					y += dy[dir];
					
					arr[x][y] = num;
					if(num == target) {
						targetX = x + 1;
						targetY = y + 1;
					}
					num++;
				}
				dir = (dir + 1) % 4;
			}
			steps++;
		}
		
		// 배열 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		System.out.println((targetX) + " " + (targetY));
	}

}
