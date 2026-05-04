class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;

        while (coupon >= 10) {
            int service = coupon / 10;   // 서비스 치킨
            answer += service;

            coupon = service + (coupon % 10); // 새 쿠폰
        }

        return answer;
    }
}