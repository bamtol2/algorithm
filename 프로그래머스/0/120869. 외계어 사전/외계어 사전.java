class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String word : dic) {
            if (word.length() != spell.length) continue;

            boolean check = true;

            for (String s : spell) {
                if (!word.contains(s)) {
                    check = false;
                    break;
                }
            }

            if (check) return 1;
        }

        return 2;
    }
}