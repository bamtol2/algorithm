import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        // 1. 오름차순 정렬
        Arrays.sort(numbers);

        int n = numbers.length;
        
        // 2. 가장 큰 두 수의 곱
        int max1 = numbers[n - 1] * numbers[n - 2];
        
        // 3. 가장 작은 두 수의 곱
        int max2 = numbers[0] * numbers[1];
        
        // 4. 둘 중 큰 값 반환
        return Math.max(max1, max2);
    }
}
