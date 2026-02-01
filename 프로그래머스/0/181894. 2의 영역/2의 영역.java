import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int first = -1, last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (first == -1) first = i;
                last = i;
            }
        }

        if (first == -1) return new int[]{-1};
        return Arrays.copyOfRange(arr, first, last + 1);
    }
}
