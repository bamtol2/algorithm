class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] s = quiz[i].split(" ");

            int x = Integer.parseInt(s[0]);
            String op = s[1];
            int y = Integer.parseInt(s[2]);
            int z = Integer.parseInt(s[4]);

            int result = op.equals("+") ? x + y : x - y;

            answer[i] = (result == z) ? "O" : "X";
        }

        return answer;
    }
}