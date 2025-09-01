import java.io.*;
import java.util.*;

public class Main {
	static int N,apartmentCount;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		List<Integer> answer = new ArrayList<>();
		int apartmentComplex = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				apartmentCount = 0;
				if (arr[i][j] == 1) {
					dfs(i,j);
					apartmentComplex++;
					answer.add(apartmentCount);
				}
			}
		}
		
		Collections.sort(answer);
		
		System.out.println(apartmentComplex);
		
		for (int a : answer) {
			System.out.println(a);
		}
	}
	
	public static void dfs(int x, int y) {
		arr[x][y] = 0;
		apartmentCount++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 1) {
				dfs(nx,ny);
			}
		}
	}
}
