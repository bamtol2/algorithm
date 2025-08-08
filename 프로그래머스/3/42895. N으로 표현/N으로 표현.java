import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // dp를 넣을 리스트 생성
        List<Set<Integer>> dp = new LinkedList<>();
        
        // 0에는 아무것도 없으니까 넣음
        dp.add(new HashSet<>());
        
        // N번 사용한 배열을 구함
        // 8보다 크면 -1을 반환한다 했으므로 8번사용하느거까지
        for (int i = 1; i <= 8; i++){
            // N번 사용한 사칙연산들을 담을 set 생성
            Set<Integer> currentSet = new HashSet<>();
            
            // N, NN 과 같이 연결되어있는것들 먼저 저장
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            currentSet.add(repeated);
            
            // 이제 dp별로 사칙연산 수행
            for (int j = 1; j < i; j++){
                for (int a : dp.get(j)){
                    for (int b : dp.get(i-j)){
                        currentSet.add(a+b);
                        currentSet.add(a-b);
                        currentSet.add(a * b);
                        if(b != 0) currentSet.add(a/b);
                    }
                }
            }
            
            if (currentSet.contains(number)){
                return i;
            }
            
            dp.add(currentSet);
            
        }
        return -1;
    }
}