class Solution {
    public int solution(int n) {
        int fact = 1;
        int i = 1;
        
        while (fact * i <= n) {
            fact *= i;
            i++;
        }
        
        return i - 1;
    }
}