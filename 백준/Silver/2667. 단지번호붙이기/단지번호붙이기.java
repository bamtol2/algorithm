import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int arr[][];
	static List<Integer> apartment = new ArrayList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		int apartmentCount = 0; //총 단지 수
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] = 0;
					int sum = bfs(i,j);
					apartmentCount += 1;
					apartment.add(sum);
				}
			}
		}
		
		System.out.println(apartmentCount);
		
		Collections.sort(apartment);
		
		for (int a : apartment) {
			System.out.println(a);
		}
		
	}
	
	public static int bfs(int x, int y) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.addFirst(new int[] {x,y});
		int sum = 1;
		
		while (!deque.isEmpty()) {
			int[] current = deque.removeLast();
			
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 1) {
					arr[nx][ny] = 0;
					deque.addFirst(new int[] {nx,ny});
					sum += 1;
				}
			}
		}
		return sum;
	}
}
