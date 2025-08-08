import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // dp[i] = N을 i번 사용해서 만들 수 있는 "모든 숫자들의 집합"
        // 예: dp[1] = {5}, dp[2] = {55, 5+5, 5-5, 5*5, 5/5}
        // List는 '순서대로 저장'하고, 각 칸에 HashSet을 넣어서 '중복 없이 숫자 저장'
        List<Set<Integer>> dp = new ArrayList<>();
        
        // dp[0]은 의미 없는 칸 (1번부터 시작하기 위해 비워둠)
        dp.add(new HashSet<>());
        
        // N 사용 횟수를 1부터 8까지 시도(8회 초과면 문제 조건상 -1 반환)
        // i = N 사용횟수라고 생각 i개를 만들려면 i를 두개의 숫자 j, i-j 로 나눠서 만들 수 있다
        // 예를 들면 i = 4면 (1,3),(2,2),(3,1) 이렇게 있다
        for (int i = 1; i <= 8; i++){
            // 이번 턴(N을 i번사용)에서 만들 수 있는 모든 숫자를 저장할 Set
            Set<Integer> currentSet = new HashSet<>();
            
            // N, NN, NNN 같은 "붙인 수" 를 먼저 추가
            // 예 : i = 3, N=5 -> 555
            // String.valueOf(N) -> N이 원래 정수 타입(int)이니 문자열로 바꿔줌
            // repeat(i) -> 문자열을 i번 반복한 새 문자열을 반환
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(i));
            currentSet.add(repeatedN);
            
            // 이전 dp 값들을 조합해서 새로운 값 만들기
            // dp[j] 와 dp[i-j] 를 각각 꺼내와서 사칙연산 초함
            // j는 두 부분으로 나누는 기준점
            for (int j = 1; j < i; j++){
                for (int a : dp.get(j)){
                    for (int b : dp.get(i-j)){
                        currentSet.add(a+b); //덧셈
                        currentSet.add(a-b); //뺄셈
                        currentSet.add(a*b); //곱셈
                        if (b != 0) currentSet.add(a/b); // 나눗셈 (0 나누기 방지)
                    }
                }
            }
            
            // 목표 숫자가 currentSet 안에 있으면 N 사용 횟수 i 반환
            if (currentSet.contains(number)){
                return i;
            }
            
            // dp[i]에 currentSet 저장
            dp.add(currentSet);
        }
        
        // 8번 이하로 못 만들면 -1 반환
        return -1;
        
       
    }
}