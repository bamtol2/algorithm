import java.io.*;
import java.util.*;

public class Main {
    static int t,n;
    static int[][] pos;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++){
            n = Integer.parseInt(br.readLine());

            pos = new int[n+2][2];
            visited = new boolean[n+2];

            // 좌표 입력
            for (int i = 0; i < n + 2; i++){
                st = new StringTokenizer(br.readLine());
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
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
            if (cur == n + 1){
                return true;
            }

            for (int i = 0; i < n+2; i++){
                if (!visited[i]){
                    int dist = Math.abs(pos[cur][0] - pos[i][0])
                            + Math.abs(pos[cur][1] - pos[i][1]);

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
