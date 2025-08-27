import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{2,1,2,3,2,4,2,5};
        int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int first_c = 0, second_c = 0, third_c = 0;
        
        for (int i = 0; i < answers.length; i++){
            if (answers[i] == first[i % first.length]) first_c++;
            if (answers[i] == second[i % second.length]) second_c++;
            if (answers[i] == third[i % third.length]) third_c++;
        }
        
        int maxScore = Math.max(first_c, Math.max(second_c, third_c));
        
        List<Integer> result = new ArrayList<>();
        if (first_c == maxScore) result.add(1);
        if (second_c == maxScore) result.add(2);
        if (third_c == maxScore) result.add(3);
        
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }
        
        return arr;
    }
}