import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int[] move = {1,-1,2};
    static int[] number = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        q.add(N);
        number[N] = 1;

        bfs(q);

        System.out.println(number[K] - 1);

    }
    static void bfs(Queue<Integer> q){
        while(!q.isEmpty()){
            int cur = q.poll();

            for (int i = 0; i < 3; i++){
                int next;
                if (i == 2) {
                    next = cur * 2;
                } else {
                    next = cur + move[i];
                }
                // 범위 확인
                if (next < 0 || next >= 100001) continue;

                if(number[next] == 0){
                    q.add(next);
                    number[next] = number[cur] + 1;
                }

                if(next == K){
                    return;
                }
            }
        }
    }
}
