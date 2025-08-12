class Solution {
    public int solution(int n) {
        // n명이 모두 1조각 이상 먹으려면, 사람 수를 7로 나눈 후 올림 처리
        int answer = (n + 6) / 7; // 올림 계산: (n + 7 - 1) / 7
        return answer;
    }
}
