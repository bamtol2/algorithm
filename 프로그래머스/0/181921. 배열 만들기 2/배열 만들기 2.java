import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            String s = String.valueOf(i);
            boolean ok = true;

            for (char c : s.toCharArray()) {
                if (c != '0' && c != '5') {
                    ok = false;
                    break;
                }
            }

            if (ok) list.add(i);
        }

        if (list.isEmpty()) return new int[]{-1};

        return list.stream().mapToInt(i -> i).toArray();
    }
}