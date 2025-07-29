import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] finish = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < progresses.length ; i++){
            finish[i] = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }
        
        int current = finish[0];
        int count = 1;
        
        for (int i = 1; i < finish.length; i++){
            if (finish[i] <= current){
                count++;
            } else {
                list.add(count);
                current = finish[i];
                count = 1;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}