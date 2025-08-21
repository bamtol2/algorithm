class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[] answer = new int[len];

        // n번째 이후 원소들을 먼저 answer에 넣기
        int idx = 0;
        for (int i = n; i < len; i++) {
            answer[idx++] = num_list[i];
        }

        // n번째까지 원소들을 뒤에 붙이기
        for (int i = 0; i < n; i++) {
            answer[idx++] = num_list[i];
        }

        return answer;
    }
}
