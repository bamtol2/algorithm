import java.util.*;
import java.io.*;

public class Main {
	static int n,L,R;
	static int[][] arr;
	static int[] dx = {0,0,-1,1}; // 좌 우
	static int[] dy = {-1,1,0,0}; // 상 하
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int moveCount = 0; //계란이 움직여서합쳐진 수
		
		while(true) {
			visited = new boolean[n][n];
			boolean moved = false;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						List<int[]> eggs = new ArrayList<>();
						int sum = bfs(i,j,eggs);
						
						// 합친 크기가 2 이상이면 재분배
						if (eggs.size() > 1) {
							int avg = sum / eggs.size();
							for (int[] egg : eggs) {
								arr[egg[0]][egg[1]] = avg;
							}
							moved = true;
						}
					}
				}
			}
			if (!moved) break;
			moveCount++;
		}
		System.out.println(moveCount);
	}
	
	
	public static int bfs(int x, int y, List<int[]> eggs){
		Deque<int[]> deque = new ArrayDeque<>();
		deque.addFirst(new int[] {x,y});
		visited[x][y] = true;
		eggs.add(new int[] {x,y});
		int sum = arr[x][y];
		
		while(!deque.isEmpty()) {
			int[] current = deque.removeLast();
			int cx = current[0];
			int cy = current[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				// 경계 안에 있고, 방문하지 않았다면
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
					int diff = Math.abs(arr[cx][cy] - arr[nx][ny]);
					// L이상 R이하이면 합쳐야함
					if (L <= diff && diff <= R) {
						visited[nx][ny] = true;
						deque.addFirst(new int[] {nx,ny});
						eggs.add(new int[] {nx,ny});
						sum += arr[nx][ny];
					}
				}
			}
		}
		return sum;
		
	}
}
