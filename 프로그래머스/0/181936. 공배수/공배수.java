class Solution {
    public int solution(int number, int n, int m) {
        // number가 n과 m의 배수이면 1, 아니면 0 반환
        if (number % n == 0 && number % m == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
