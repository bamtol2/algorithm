
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] customer = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            customer[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long leader = Long.parseLong(st.nextToken());
        long follower = Long.parseLong(st.nextToken());

        long answer = 0;
        for (int i = 0; i < n; i++) {
            long check = customer[i] - leader;
            long fcheck = 0;
            if (check > 0) {
                fcheck = (check + follower - 1) / follower; // 올림 계산
            }
            answer += 1 + fcheck; // 리더 1명 + 팔로워
        }

        System.out.println(answer);
    }
}