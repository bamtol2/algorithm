import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        // 1. 배열을 오름차순으로 정렬합니다.
        Arrays.sort(array);
        
        // 2. 정중앙에 위치한 인덱스의 값을 반환합니다.
        // 예: 길이가 5라면 인덱스 2 (5 / 2 = 2)가 중앙값입니다.
        return array[array.length / 2];
    }
}