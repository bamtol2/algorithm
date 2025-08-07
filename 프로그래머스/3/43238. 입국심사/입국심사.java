class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        
        // 시간을 돌면서 가장 시간이 많이 걸리는 곳을 찾는다
        for (int time : times){
            if (right < time){
                right = time;
            }
        }
        
        // 가장 시간이 많이 걸리는 타임은 가장 많이 시간이 걸리는 곳 * 사람수
        right *= n; 
        long answer = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long people = 0;
            
            // mid(최소시간) 동안 처리할 수 있는 사람의 수
            for (int time : times){
                people += mid / time;
            }
            
            // 만약 처리할 수 있는 사람 수가 n 보다 적으면 시간이 적으므로 시간을 늘려야함
            if (people >= n){
                right = mid - 1;
                answer = mid;
            } else {
                // 만약 처리할 수 있는 사람 수가 n 보다 많으면 시간이 많으므로 mid를 줄여야함
                left = mid + 1;
            }
        }
        
        return answer;
    }
}