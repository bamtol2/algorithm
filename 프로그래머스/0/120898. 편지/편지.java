class Solution {
    public int solution(String message) {
        if (message == null) return 0; // 혹시 null 입력이 들어올 경우 대비
        return message.length() * 2;
    }
}
