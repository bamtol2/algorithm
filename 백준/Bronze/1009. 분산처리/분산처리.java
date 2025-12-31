import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 1;
            int base = a % 10;

            for (int i = 0; i < b; i++) {
                result = (result * base) % 10;
            }

            if (result == 0) result = 10;
            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
