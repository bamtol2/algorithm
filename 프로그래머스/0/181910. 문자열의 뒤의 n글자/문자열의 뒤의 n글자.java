class Solution {
    public String solution(String my_string, int n) {
        // 문자열의 끝에서 n글자 시작 위치 계산
        int start = my_string.length() - n;
        // substring으로 잘라서 반환
        return my_string.substring(start);
    }
}
