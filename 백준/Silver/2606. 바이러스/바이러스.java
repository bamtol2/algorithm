import java.util.*;
import java.io.*;

public class Main {
    static int N,M,answer;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        answer = 0;

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        System.out.println(answer);

    }
    static void dfs(int start){
        visited[start] = true;

        for (int next : graph[start]){
            if (!visited[next]){
                answer += 1;
                dfs(next);
            }
        }
    }
}
