class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;

        for (int idx = 0; idx < code.length(); idx++) {
            char c = code.charAt(idx);

            if (c == '1') {
                mode = 1 - mode;
            } else {
                if (mode == 0 && idx % 2 == 0) ret.append(c);
                if (mode == 1 && idx % 2 == 1) ret.append(c);
            }
        }

        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
}