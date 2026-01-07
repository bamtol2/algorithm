import java.util.*;
import java.io.*;

public class Main {
    static int F,S,G,U,D;
    static int[] tower;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 건물 총 높이
        S = Integer.parseInt(st.nextToken()); // 내 위치
        G = Integer.parseInt(st.nextToken()); // 회사 위치
        U = Integer.parseInt(st.nextToken()); // U 칸 위로
        D = Integer.parseInt(st.nextToken()); // D 칸 아래로

        tower = new int[F+1];
        tower[S] = 1;
        q.add(S);

        bfs();


    }

    static void bfs(){
        while(!q.isEmpty()){
            int cur = q.poll();

            // 종료 조건
            if (cur == G){
                System.out.println(tower[cur]-1);
                return;
            }
            for (int i = 0; i < 2; i++){
                int next;
                // 0인 경우 위로
                if(i == 0){
                    next = cur + U;
                } else {
                    next = cur - D;
                }

                // 범위 확인
                if (next < 1 || next > F) continue;

                // 범위 안인경우
                if (tower[next] == 0){
                    tower[next] = tower[cur] + 1;
                    q.add(next);
                }
            }
        }
        System.out.println("use the stairs");
    }
}
