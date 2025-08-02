import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int a = 0; a < commands.length; a++){
            ArrayList<Integer> arr = new ArrayList<>();
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            for (int b = i-1; b < j; b++){
                arr.add(array[b]);
            }
            Collections.sort(arr);
            answer[a] = arr.get(k-1);
        }
        return answer;
    }
}