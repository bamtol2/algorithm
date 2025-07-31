import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int s : scoville){
            heap.add(s);
        }
        
        int count = 0;
        
        // 힙의 사이즈가 2개 이상이고, 힙에서 peek했을때(가장 작은 값을 꺼냈을때) K보다 작을때까지
        while (heap.size() >= 2 && heap.peek() < K){
            int first = heap.poll(); //가장 작은 음식
            int second = heap.poll(); //두 번째로 작은 음식
            int mixed = first + (second * 2);
            heap.add(mixed); //다시 힙에 넣음
            count++;
        }
        
        return heap.peek() >= K ? count : -1;
    }
}