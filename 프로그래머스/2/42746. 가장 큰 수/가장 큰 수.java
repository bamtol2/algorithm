import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        // 1. 정수를 문자열로 바꿔준다
        for (int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 내림차순 정렬로 정렬해준다(더했을때 커지는 값이 앞으로 간다)
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        
        if (arr[0].equals("0")) return "0";
        
        String answer = "";
        
        for(String a : arr){
            answer += a;
        }
        return answer;
    }
}