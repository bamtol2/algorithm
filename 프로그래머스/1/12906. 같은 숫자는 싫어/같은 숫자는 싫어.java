import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int compare = arr[0];
        list.add(compare);
        
        for(int i = 1; i < arr.length ; i++){
            if(arr[i] != compare){
                list.add(arr[i]);
                compare = arr[i];
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}