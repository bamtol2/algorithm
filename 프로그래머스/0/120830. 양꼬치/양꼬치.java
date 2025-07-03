class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int discount = n / 10;
        answer = (n * 12000) + (k * 2000) - (discount * 2000);
        return answer;
    }
}