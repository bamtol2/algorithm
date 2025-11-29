import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        if (num_list == null || num_list.length <= 5) return new int[0];
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 5, num_list.length);
    }
}
