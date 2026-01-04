import java.util.*;
import java.io.*;

public class Main {
	static int N,M,V;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++){
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		// "작은 번호 먼저 방문" => 인접 리스트 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		// DFS
		visited = new boolean[N+1];
		dfs(V);
		sb.append('\n');

		// BFS
		visited = new boolean[N+1];
		bfs(V);

		System.out.print(sb.toString());
		}

		static void dfs(int cur){
			visited[cur] = true;
			sb.append(cur).append(' ');

			for (int next : graph[cur]){
				if (!visited[next]){
					dfs(next);
				}
			}
		}

		static void bfs(int start){
			Queue<Integer> q = new LinkedList<>();
			visited[start] = true;
			q.add(start);

			while(!q.isEmpty()){
				int cur = q.poll();
				sb.append(cur).append(' ');

				for (int next : graph[cur]){
					if (!visited[next]){
						visited[next] = true;
						q.add(next);
					}
				}
			}
		}
}
