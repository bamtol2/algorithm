import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        
        for (int num : array) {
            if (Math.abs(num - n) < Math.abs(answer - n)) {
                answer = num;
            } else if (Math.abs(num - n) == Math.abs(answer - n) && num < answer) {
                answer = num;
            }
        }
        
        return answer;
    }
}