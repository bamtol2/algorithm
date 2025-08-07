class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        
        for (long time : times){
            if (time > right) {
                right = time;
            }
        }
        
        right *= n; // 가장 오랜 시간이 걸림
        
        long answer = right; // 가장 큰 시간으로 초기화
        
        while (left <= right){
            long mid = (left + right) / 2;
            
            // mid 시간 안에 몇명을 처리 할 수 있는지 계산
            long people = 0;
            for (long time : times){
                people += mid / time;
            }
            
            if (people >= n){
                answer = mid;
                right = mid - 1;
            } else { // 시간 과다
                left = mid + 1;
            }
        }
        return answer;
    }
}