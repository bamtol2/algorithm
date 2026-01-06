import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M; //가로(열)
	static int N;  //세로(행)
	static int H; //높이
	static int[][][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		Queue<int[]> q = new LinkedList<>();
		
		int[] dr = {0,0,-1,1,0,0};
		int[] dc = {-1,1,0,0,0,0};
		int[] dh = {0,0,0,0,-1,1};
		
		
		for (int h = 0; h < H; h++) {
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < M; col++) {
					map[h][row][col] = Integer.parseInt(st.nextToken());
					if (map[h][row][col] == 1) {
						q.add(new int[] {h,row,col});
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int high = current[0];
			int row = current[1];
			int col = current[2];
			
			for(int i = 0; i < 6; i++) {
				int nh = high + dh[i];
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(0 <= nh && nh < H && 0 <= nr && nr < N && 0 <= nc && nc < M) {
					if(map[nh][nr][nc] == 0) {
						map[nh][nr][nc] = map[high][row][col] + 1;
						q.add(new int[] {nh,nr,nc});
					}
				}
			}	
		}
		
		int answer = 0;
		for(int[][]  plate:map) {
			for(int[] line:plate) {
				for(int tomato:line) {
					if(tomato == 0) {
						System.out.println(-1);
						return;
					}
					answer = Math.max(tomato, answer);
				}
			}
		}
		System.out.println(answer-1);
	}
}
