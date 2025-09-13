import java.util.*;
import java.io.*;

public class Main {
	static int N,K,totalLength,zeroCnt;
	static int[] belt;
	static boolean[] robot;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		totalLength = N * 2;
		
		belt = new int[totalLength];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < totalLength; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = simulate();
		System.out.println(answer);
	}
	
	public static int simulate() {
		int step = 0;
		zeroCnt = 0;
		
		while(true) {
			step++;
			
			// 1) 벨트 회전 with 로봇
			rotate();
			
			// 2) 내리는 자리에 로봇이 있으면 내림
			if (robot[N-1]) robot[N-1] = false;
			
			// 3) 가장 먼저 벨트위에 올라가있는 로봇부터 벨트가 회전하는 방향으로 1칸 이동
			move();
			
			// 4) 첫번째 칸이 내구도 0이 아니면 새로운 로봇을 올림
			addRobot();
			
			// 5) 내구도가 0인 칸의 개수가 K개 이상이면 과정 종료
			if (zeroCnt >= K) {
				return step;
			}
		}
	}
	
	public static void rotate() {
		// 1. 벨트 회전
		int last = belt[totalLength - 1];
		for (int i = totalLength - 1; i > 0; i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = last;
		
		// 2. 벨트 위에 로봇이 있다면 같이 회전
		for (int i = N-2; i > 0; i-- ) {
			robot[i] = robot[i-1];
		}
		robot[0] = false;
	}
	
	public static void move() {
		for (int i = N-2; i >= 0; i--) {
			// 이동하려는 로봇이 있고
			if (robot[i]) {
				// 이동하려는 칸에 로봇이 없고, 그 칸의 내구도가 1 이상이면 이동
				if (!robot[i+1] && belt[i+1] > 0) {
					belt[i+1]--; //이동하려는 칸 내구도 1감소
					robot[i] = false;
					if (belt[i+1] == 0) zeroCnt++;
					// 이동한 칸이 내리는 칸이면
					if (i + 1 == N - 1) {
						robot[N-1] = false;
					} else {
						// 이동한 칸이 내리는 칸이 아니라면 로봇이 있다고 표시
						robot[i+1] = true;
					}
				}
			}
		}
	}
	
	public static void addRobot() {
		if (belt[0] > 0) {
			robot[0] = true;
			belt[0]--;
			if (belt[0] == 0) {
				zeroCnt++;
			}
		}
	}
}
