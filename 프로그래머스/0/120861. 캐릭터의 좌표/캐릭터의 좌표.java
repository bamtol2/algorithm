class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        for (String key : keyinput) {
            switch (key) {
                case "up":
                    if (y < maxY) y++;
                    break;
                case "down":
                    if (y > -maxY) y--;
                    break;
                case "left":
                    if (x > -maxX) x--;
                    break;
                case "right":
                    if (x < maxX) x++;
                    break;
            }
        }

        return new int[]{x, y};
    }
}