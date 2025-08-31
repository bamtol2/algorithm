import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int MaxValue = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		System.out.println(MaxValue);
	}
	
	private static void dfs(int day, int profit) {
		if (day >= N) {
			MaxValue = Math.max(MaxValue, profit);
			return;
		}
		
		// 1. 외주를 선택하는 경우 (기간을 넘으면 선택 불가)
		if (day + arr[day][0] <= N) {
			dfs(day + arr[day][0], profit + arr[day][1]);
		}
		
		// 2. 외주를 선택하지 않는 경우
		dfs(day + 1, profit);
	}
	
}
