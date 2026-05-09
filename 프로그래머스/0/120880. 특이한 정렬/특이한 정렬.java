import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> {
                    int diffA = Math.abs(a - n);
                    int diffB = Math.abs(b - n);

                    if (diffA == diffB) {
                        return b - a; // 거리가 같으면 큰 수 먼저
                    }

                    return diffA - diffB; // n과 가까운 순서
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}