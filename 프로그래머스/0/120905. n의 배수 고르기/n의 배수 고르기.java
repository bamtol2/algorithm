class Solution {
    public int[] solution(int n, int[] numlist) {
        int count = 0;

        for(int num : numlist){
            if(num % n == 0) count++;
        }

        int[] answer = new int[count];
        int idx = 0;

        for(int num : numlist){
            if(num % n == 0){
                answer[idx++] = num;
            }
        }

        return answer;
    }
}