import java.util.*;
import java.io.*;

public class Main {
    static int t,n;
    static int[][] songdo;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++){
            n = Integer.parseInt(br.readLine());
            songdo = new int[n+2][2];
            visited = new boolean[n+2];

            for (int i = 0; i < n+2; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                songdo[i][0] = a;
                songdo[i][1] = b;
            }
            if (bfs()){
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }
    }
    static boolean bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            // 페스티벌 도착
            if (cur == n+1){
                return true;
            }

            for (int i = 1; i < n+2; i++){
                if (!visited[i]){
                    int dist = Math.abs(songdo[cur][0] - songdo[i][0]) + Math.abs(songdo[cur][1] - songdo[i][1]);

                    if (dist <= 1000){
                        visited[i] = true;
                        q.add(i);
                    }
                }

            }
        }
        return false;
    }
}
