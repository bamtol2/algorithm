import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 전체 사람의 수
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        dist = new int[N+1];
        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        bfs(a,b);
    }

    static void bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            // 종료 조건
            if (now == end){
                System.out.println(dist[now]);
                return;
            }
            for (int next : graph[now]){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        System.out.println(-1);
    }
}
