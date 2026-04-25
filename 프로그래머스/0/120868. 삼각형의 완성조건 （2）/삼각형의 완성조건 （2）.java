class Solution {
    public int solution(int[] sides) {
        int a = sides[0];
        int b = sides[1];
        return a + b - Math.abs(a - b) - 1;
    }
}