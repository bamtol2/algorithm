class Solution {
    public int solution(int n, int t) {
        // n * 2^t 계산
        return n * (int)Math.pow(2, t);
    }
}
