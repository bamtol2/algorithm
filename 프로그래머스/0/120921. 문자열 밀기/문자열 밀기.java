class Solution {
    public int solution(String A, String B) {
        String pushed = A;

        for (int i = 0; i < A.length(); i++) {
            if (pushed.equals(B)) {
                return i;
            }

            pushed = pushed.charAt(pushed.length() - 1) 
                   + pushed.substring(0, pushed.length() - 1);
        }

        return -1;
    }
}