class Solution {
    public String[] solution(String[] picture, int k) {
        int h = picture.length;
        int w = picture[0].length();
        
        String[] answer = new String[h * k];
        int idx = 0;
        
        for (int i = 0; i < h; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < w; j++) {
                for (int t = 0; t < k; t++) {
                    sb.append(picture[i].charAt(j));
                }
            }
            
            String enlargedRow = sb.toString();
            for (int t = 0; t < k; t++) {
                answer[idx++] = enlargedRow;
            }
        }
        
        return answer;
    }
}
