class Solution {
    public int solution(String s) {
        String[] arr = s.split(" ");
        int[] stack = new int[arr.length];
        int idx = 0;

        for (String str : arr) {
            if (str.equals("Z")) {
                idx--;
            } else {
                stack[idx++] = Integer.parseInt(str);
            }
        }

        int sum = 0;
        for (int i = 0; i < idx; i++) {
            sum += stack[i];
        }

        return sum;
    }
}