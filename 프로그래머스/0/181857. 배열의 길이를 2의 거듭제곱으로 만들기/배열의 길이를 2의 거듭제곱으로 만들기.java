class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int size = 1;
        while (size < n) size <<= 1;

        int[] answer = new int[size];
        for (int i = 0; i < n; i++) {
            answer[i] = arr[i];
        }
        return answer;
    }
}
