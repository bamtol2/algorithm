class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);

            if (c == 'a' || c == 'A') {
                sb.append('A');
            } else if (c >= 'A' && c <= 'Z') { // 'A' 제외한 대문자들
                sb.append((char) (c + ('a' - 'A')));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
