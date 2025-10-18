class Solution {
    public int solution(int a, int b) {
        int ab = Integer.parseInt("" + a + b);
        int result = 2 * a * b;
        return ab >= result ? ab : result;
    }
}
