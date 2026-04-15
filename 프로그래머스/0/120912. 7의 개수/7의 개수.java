class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int num : array) {
            for (char c : String.valueOf(num).toCharArray()) {
                if (c == '7') answer++;
            }
        }
        
        return answer;
    }
}