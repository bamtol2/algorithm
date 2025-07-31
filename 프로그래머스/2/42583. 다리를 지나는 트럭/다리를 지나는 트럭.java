import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0; // 흐른 시간
        int totalWeight = 0; // 현재 다리 위 트럭 무게 합
        int index = 0; // 다음에 올라갈 트럭 인덱스
        
        // 다리를 처음에 빈 공간으로 채움 (다리 길이만큼)
        for(int i = 0; i < bridge_length; i++){
            bridge.add(0); // 0은 빈 공간을 의미함
        }
        
        while(index < truck_weights.length){
            time ++; // 시간 흐름 1초
            
            // 1. 다리에서 한 칸 나가기 (맨 앞 요소 제거)
            totalWeight -= bridge.poll();
            
            // 2. 다음 트럭을 올릴 수 있는지 확인
            if (totalWeight + truck_weights[index] <= weight){
                // 다음 트럭을 올림
                bridge.add(truck_weights[index]);
                totalWeight += truck_weights[index];
                index++;
            } else {
                // 트럭을 올릴 수 없으면 빈 공간을 채움
                bridge.add(0);
            }
        }
        
        return time + bridge_length;
    }
}