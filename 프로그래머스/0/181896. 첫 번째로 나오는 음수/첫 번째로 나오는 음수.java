class Solution {
    public int solution(int[] num_list) {
        // 배열을 처음부터 순회
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) { // 음수이면
                return i; // 해당 인덱스 반환
            }
        }
        return -1; // 음수가 없으면 -1 반환
    }
}