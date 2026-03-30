class Solution {
    public int solution(int n) {
        int lcm = 6 * n / gcd(6, n);
        return lcm / 6;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}