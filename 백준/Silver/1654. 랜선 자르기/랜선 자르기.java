import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static long left = 1, right = Integer.MIN_VALUE;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        parametricSearch();

        br.close();
    }
    static void parametricSearch() {
        while (left <= right) {
            long mid = (left + right) / 2;
            long LAN = 0;
            for (int i = 0; i < arr.length; i++) {
                LAN += (arr[i] / mid);
            }
            if (LAN>=N){
                left = mid + 1;
            } else if (LAN < N) {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}