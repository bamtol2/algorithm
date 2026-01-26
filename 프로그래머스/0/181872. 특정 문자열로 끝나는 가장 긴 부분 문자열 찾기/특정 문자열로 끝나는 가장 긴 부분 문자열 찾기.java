class Solution {
    public String solution(String myString, String pat) {
        int idx = myString.lastIndexOf(pat);
        return idx == -1 ? "" : myString.substring(0, idx + pat.length());
    }
}
