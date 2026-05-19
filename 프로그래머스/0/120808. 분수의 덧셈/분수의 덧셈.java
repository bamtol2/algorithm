class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        // 분수 덧셈
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        
        // 최대공약수 구하기
        int gcd = gcd(numer, denom);
        
        // 기약분수로 만들기
        numer /= gcd;
        denom /= gcd;
        
        return new int[] {numer, denom};
    }
    
    // 최대공약수(GCD)
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}