class Solution {
    public int[] solution(int money) {
        int americano = money / 5500;
        int remain = money % 5500;
        return new int[]{americano, remain};
    }
}