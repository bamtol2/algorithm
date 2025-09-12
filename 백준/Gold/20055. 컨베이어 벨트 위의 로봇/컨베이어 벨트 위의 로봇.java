import java.util.*;
import java.io.*;

public class Main {
	static int n,k,total;
	static int[] movingWalk;
	static boolean[] people;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		total = n * 2;
		
		movingWalk = new int[total]; // 안정성 배열
		people = new boolean[n]; // 사람이 서있는지 확인하는 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < total; i++) {
			movingWalk[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = simulate();
		System.out.println(count);
	}
	
	static int simulate() {
		int step = 0; // 현재 진행라운드 수
		
		int zeroCnt = 0;
		
		while(true) {
			step += 1;
			
			// 1. 무빙워크 회전(사람이 있으면 같이 회전)
			rotate();
			
			// 2. n번칸 위치에 사람이 위치하면 그 즉시 내린다
			if(people[n-1]) people[n-1] = false;
			
			// 3. 무빙워크에 올라간 사람부터 무빙워크가 회전하는 방향으로 한 칸 이동할 수 있으면 이동
			for (int i = n-2; i >= 0; i--) {
				// i칸에 사람이 없으면 pass
				if (!people[i]) continue;
				int next = i+1;
				// 앞선 칸에 사람이 없고, 안정성이 0보다 클 경우 앞으로 이동
				if (!people[next] && movingWalk[next] > 0) {
					people[i] = false;
					movingWalk[next]--;
					if (movingWalk[next] == 0) {
						zeroCnt++;
					}
					// 이동 결과가 내리는 위치라면 즉시 내리고 표시하지않음
					if (next == n-1) {
						people[n-1] = false;
					} else {
						// 이동 결과가 내리는 위치가 아니라면 사람이 있다고 표시
						people[next] = true;
					}
				}
			}
			
			// 4. 사람 올림
			if (!people[0] && movingWalk[0] > 0) {
				people[0] = true;
				movingWalk[0]--;
				if (movingWalk[0] == 0) zeroCnt++;
			}
			
			// 5. 과정 종료
			if (zeroCnt >= k) return step;
		}
	}
	
	static void rotate() {
		// 무빙워크 회전
		int last = movingWalk[total-1];
		for (int i = total - 1; i > 0; i--) {
			movingWalk[i] = movingWalk[i-1];
		}
		movingWalk[0] = last;
		
		// 사람이 올라가있으면 같이 회전
		for (int i = n-1; i > 0; i--) {
			people[i] = people[i-1];
		}
		people[0] = false;
	}
}
