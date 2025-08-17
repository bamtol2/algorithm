class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;  // 합을 저장할 변수
        for (int num : numbers) {  // 배열을 앞에서부터 순회
            answer += num;         // 현재 원소 더하기
            if (answer > n) {      // 합이 n보다 커지면 멈춤
                break;
            }
        }
        return answer;  // 최종 합 반환
    }
}
