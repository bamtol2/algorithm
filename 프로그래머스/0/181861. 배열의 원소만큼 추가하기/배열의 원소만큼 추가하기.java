class Solution {
    public int[] solution(int[] arr) {
        int size = 0;
        for (int a : arr) size += a;

        int[] answer = new int[size];
        int idx = 0;

        for (int a : arr) {
            for (int i = 0; i < a; i++) {
                answer[idx++] = a;
            }
        }
        return answer;
    }
}
