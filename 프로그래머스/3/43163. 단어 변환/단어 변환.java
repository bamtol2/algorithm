import java.util.*;

class Node{
    String word;
    int step;
    
    Node(String word, int step){
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // 바로 종료되는 조건
        if (!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        int n = words.length;
        boolean[] visited = new boolean[n];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin,0));
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            // 종료 조건 설정
            if (current.word.equals(target)){
                return current.step;
            }
            
            for (int i = 0; i < n; i++){
                if(!visited[i]){
                    String compare = words[i];
                    int diff = 0;
                    for (int j = 0; j < compare.length(); j++){
                        if (current.word.charAt(j) != compare.charAt(j)){
                            diff++;
                        }
                    }
                    // 단어가 한글자 빼고 같다면
                    if (diff == 1){
                        visited[i] = true;
                        queue.offer(new Node(compare, current.step + 1));
                    }
                }
            }
            
        }
        return 0;
    }
}