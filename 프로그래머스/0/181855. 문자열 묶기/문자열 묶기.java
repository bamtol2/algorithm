class Solution {
    public int solution(String[] strArr) {
        int[] cnt = new int[31]; // 문자열 길이 최대 30
        int max = 0;

        for (String s : strArr) {
            int len = s.length();
            cnt[len]++;
            max = Math.max(max, cnt[len]);
        }

        return max;
    }
}
