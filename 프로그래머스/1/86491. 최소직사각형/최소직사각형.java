import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        // 가로, 세로
        int width = 0;
        int length = 0;
        
        for (int[] s : sizes){
            int width2 = Math.max(s[0],s[1]);
            int length2 = Math.min(s[0],s[1]);
            
            if (width < width2){
                width = width2;
            }
            if (length < length2){
                length = length2;
            }
        }
        
        int answer = width * length;
        return answer;
    }
}