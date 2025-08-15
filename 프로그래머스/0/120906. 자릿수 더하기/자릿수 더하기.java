class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {            // n이 0이 될 때까지 반복
            answer += n % 10;      // 마지막 자리 숫자를 더함
            n /= 10;               // 마지막 자리 제거
        }

        return answer;
    }
}
