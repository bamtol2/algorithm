import java.util.*;

class Node {
    String word;
    int step;
    
    Node(String word, int step){
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words 배열에 target이 없으면 바로 0 반환
        if (!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        int n = words.length; // words 배열의 길이
        boolean[] visited = new boolean[n]; // 방문 배열 선언
        Queue<Node> queue = new LinkedList<>(); // 단어랑 단계를 함께 담기 위해 Node로 큐 생성
        queue.offer(new Node(begin,0));
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            // 종료 조건 설정
            if (current.word.equals(target)){
                return current.step;
            }
            
            // words를 돌면서
            for (int i = 0; i < n; i++){
                // 방문하지 않았으면
                if (!visited[i]){
                    int diff = 0;
                    String compare = words[i]; // 그 단어를 꺼내서
                    // 한글자씩 비교
                    for (int j = 0; j < compare.length(); j++){
                        // 서로 다른 두 단어의 글자가 다르다면
                        if (current.word.charAt(j) != compare.charAt(j)){
                            diff++;
                        }
                    }
                    // 위의 for문을 돌리고 1개의 글자만 다르다면 
                    if (diff == 1){
                        visited[i] = true; //방문 처리 해주고
                        queue.offer(new Node(compare, current.step + 1));
                        
                    }
                }
            }
        }
        return 0; // while문이 다 끝났는데도 값을 반환하지못했으면 0 반환
    }
}