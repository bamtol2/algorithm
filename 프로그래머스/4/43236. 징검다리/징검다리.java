import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 바위 오름차순 정렬
        Arrays.sort(rocks);
        
        int left = 1;  // 최소 거리의 최솟값
        int right = distance; // 최소 거리의 최댓값
        int answer = 0;
        
        
        
        while (left <= right){
            int mid = (left + right) / 2; // 최소 거리 후보
            
            int start = 0; // 이전 바위 또는 시작 시점(0)
            int count = 0; //돌을 부슨 횟수
            
            // 바위 하나씩 확인
            for (int i = 0; i < rocks.length; i++){
                // 돌 사이의 차이 구하기
                int gap = rocks[i] - start; // 현재 바위와 이전 위치 간 거리
                
                // 최소 간격이 돌의 차이보다 크면
                if (mid > gap){
                    // 중간의 돌을 부스고 count 증가
                    count += 1;
                } else {
                    // 최소 간격이 gap 보다 같거나 작으면 start 갱신
                    start = rocks[i];
                }
            }
            
            // 마지막꺼랑도 확인을 해야함
            // 도착위치랑 마지막 start의 차이가 mid 보다 작으면 카운트 증가
            if (distance - start < mid)
                count++;
            
            // 제거한 바위수가 n보다 작거나 같으면 mid(최솟값이) 작다는 뜻이므로 mid값을 키워야함
            if (count <= n){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid -1;
            }
        }
        return answer;
    }
}