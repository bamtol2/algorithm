import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] parts = myStr.split("[abc]");
        List<String> list = new ArrayList<>();
        
        for (String p : parts) {
            if (!p.isEmpty()) list.add(p);
        }
        
        if (list.isEmpty()) return new String[]{"EMPTY"};
        return list.toArray(new String[0]);
    }
}
