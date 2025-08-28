
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 K 입력 받
		int K = Integer.parseInt(br.readLine());
		
		// 넣을 스택 생성
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < K; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a != 0) {
				stack.push(a);
			} else {
				stack.pop();
			}
		}
		
		int answer = 0;
		
		for (int i : stack) {
			answer += i;
		}
		
		System.out.println(answer);

		
	}
}
