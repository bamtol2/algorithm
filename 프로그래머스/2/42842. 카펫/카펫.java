import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 전체 격자 수
        
        for (int h = 1; h <= Math.sqrt(total); h++){
            if (total % h == 0){
                int w = total / h; // 가로 길이 계산
                if ((w-2) * (h-2) == yellow){ // 노란색 조건 확인
                    return new int[]{w,h};
                }
            }
        }
        return new int[]{};
    }
}