class Solution {
    public int solution(int a, int b) {
        boolean aOdd = (a % 2 != 0);
        boolean bOdd = (b % 2 != 0);
        int answer;

        if (aOdd && bOdd) {              // 둘 다 홀수
            answer = a * a + b * b;
        } else if (aOdd || bOdd) {       // 하나만 홀수
            answer = 2 * (a + b);
        } else {                         // 둘 다 홀수가 아님 (둘 다 짝수)
            answer = Math.abs(a - b);
        }

        return answer;
    }
}
