import java.util.*;

class Solution {
    List<String> answer = new ArrayList<>();
    boolean[] used;
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        
        // 도착지(a[1]) 기준으로 사전 정렬
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        // DFS 시작 ICN에서 출발, 경로 초기값은 ICN
        dfs("ICN", "ICN", tickets, 0);
        
        // 완성된 경로 중 가장 먼저 저장된 경로를 반환
        return answer.get(0).split(" ");
    }
    
    // from : 현재 위치 (출발지), paht : 지금까지 경로 (문자열형태), count : 사용한 티켓 개수, tickets : 항공권 목록
    void dfs(String from, String path, String[][] tickets, int count){
        
        // 종료 조건 : 티켓을 모두 사용했다면 (모든 경로를 연결한 것)
        // 현재까지의 경로 path를 answer에 저장하고 종료
        if (count == tickets.length){
            answer.add(path);
            return;
        }
    
        for (int i = 0; i < tickets.length; i++){
            // 사용하지 않았고, 티켓의 출발지가 현재 위치(from)와 같다면
            if (!used[i] && tickets[i][0].equals(from)){
                // 티켓을 사용 처리
                used[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1);
                used[i] = false;
            }
        }
    }
}