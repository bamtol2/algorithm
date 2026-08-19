import java.util.*;
import java.io.*;

class Solution {
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    
    public String solution(String s) {
        String[] numbers = s.split(" ");
        
        int l = numbers.length;
        
        for (int i = 0; i < l; i++){
            int a = Integer.parseInt(numbers[i]);
            maxValue = Math.max(maxValue, a);
            minValue = Math.min(minValue, a);
        }
        
        String answer = minValue + " " + maxValue;
        
        return answer;
    }
}