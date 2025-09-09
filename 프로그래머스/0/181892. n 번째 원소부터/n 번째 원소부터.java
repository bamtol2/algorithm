import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        // n번째 원소부터 끝까지 잘라서 반환 (인덱스는 0부터 시작하므로 n-1)
        return Arrays.copyOfRange(num_list, n - 1, num_list.length);
    }
}
