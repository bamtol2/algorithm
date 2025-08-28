import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // 여러 문자열을 효과적으로 합치기 위한 StringBuilder

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] shirt = new int[6];
        for (int i = 0; i < 6; i++){
            shirt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int shirt_bundle = Integer.parseInt(st.nextToken());
        int pen_bundle = Integer.parseInt(st.nextToken());

        int shirt_sum = 0;
        for (int i = 0; i < 6; i++){
            shirt_sum += (shirt[i] / shirt_bundle) + (shirt[i] % shirt_bundle == 0? 0 : 1);

        }

        sb.append(shirt_sum).append("\n").append(n / pen_bundle).append(" ").append(n%pen_bundle);
        bw.write(sb.toString());
        bw.flush();
        bw.close();



    }
}