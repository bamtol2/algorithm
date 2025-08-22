class Solution {
    public int solution(int[] num_list) {
        String odd = "";
        String even = "";
        
        // 배열 순회
        for (int n : num_list) {
            if (n % 2 == 0) {
                even += n; // 짝수면 even 문자열에 추가
            } else {
                odd += n;  // 홀수면 odd 문자열에 추가
            }
        }
        
        // 문자열이 비어 있으면 "0" 처리
        int oddNum = odd.isEmpty() ? 0 : Integer.parseInt(odd);
        int evenNum = even.isEmpty() ? 0 : Integer.parseInt(even);
        
        return oddNum + evenNum;
    }
}
