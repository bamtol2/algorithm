class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        
        // 가장 많이 걸리는 시간 계산
        for (long time : times){
            if (right < time){
                right = time;
            }
        }
        
        // 검사하는데 가장 많은 시간이 걸리는 시간 * n = 최대로 많이 걸리는 시간
        right *= n;
        long answer = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long people = 0;
            
            // 그 시간동안 처리할 수 있는 사람의 수
            for (long time : times){
                people += mid / time;
            }
            
            // 처리할 수 있는 사람수가 > 목표치(n)보다 크거나 같으면 -> 시간을 늘려줘야함
            if (people >= n){
                answer = mid;
                right = mid - 1;
            } else { // 처리할 수 있는 사람수가 > 목표치(n) 보다 작으면 -> 시간을 줄여야함
                left = mid + 1;
            }
        }
        return answer;
    }
}