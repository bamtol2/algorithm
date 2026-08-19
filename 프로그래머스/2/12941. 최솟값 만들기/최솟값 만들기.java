import java.util.*;

class Solution{
    public int solution(int []A, int []B){
        int answer = 0;
        int l = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < l; i++){
            // A의 작은 값(i) * B의 큰 값
            answer += A[i] * B[l-1-i];
        }
        
        return answer;
        
        
    }
}