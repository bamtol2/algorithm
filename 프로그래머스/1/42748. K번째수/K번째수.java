import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int a = 0; a < commands.length; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            ArrayList<Integer> list = new ArrayList<>();
            
            for (int x = i-1; x < j; x++){
                list.add(array[x]);
            }
            Collections.sort(list);
            answer[a] = list.get(k-1);
        }
        return answer;
    }
}