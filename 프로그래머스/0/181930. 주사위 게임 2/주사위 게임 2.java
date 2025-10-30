class Solution {
    public int solution(int a, int b, int c) {
        int sum = a + b + c;
        int sq = a*a + b*b + c*c;
        int cu = a*a*a + b*b*b + c*c*c;
        
        if(a == b && b == c){
            return sum * sq * cu;
        } else if(a == b || b == c || a == c){
            return sum * sq;
        } else {
            return sum;
        }
    }
}
