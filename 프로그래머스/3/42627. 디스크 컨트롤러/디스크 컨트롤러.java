import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청시간 순으로 jobs정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        // 2. 소요시간 기준으로 우선순위 큐 생성
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int time = 0; // 현재 시간
        int index = 0; // jobs 배열의 인덱스
        int total = 0; // 모든 작업의 총 대기시간 합
        int count = 0; // 처리한 작없 수
        
        // 3. 모든 작업이 처리될 때까지 반복
        while (count < jobs.length){
            // 4. 현재 시간까지 도착한 작업들을 pq에 넣음
            // (jobs 배열의 인덱스가 jobs의 길이보다 작고, joba작업이 요청되는 시점이 현재 시간보다 같거나 작으면)
            while (index < jobs.length && jobs[index][0] <= time){
                pq.offer(jobs[index]);
                index++;
            }
            
            // 5. pq가 비어있지 않으면, 가장 짧은 작업부터 처리
            if (!pq.isEmpty()){
                int[] job = pq.poll();
                time += job[1];
                total += time - job[0]; //(작업완료시간 - 요청시간)
                count++;
            } else {
                // 6. pq가 비어있으면, 다음 작업 요청 시간으로 시간 점프
                time = jobs[index][0];
            }
        }
        
        return total / jobs.length;
    }
}