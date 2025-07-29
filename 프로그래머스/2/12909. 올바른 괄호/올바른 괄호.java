class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int open = 0;
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (s.charAt(i) == '('){
                open ++;
            } else if (s.charAt(i) == ')'){
                if (open == 0){
                    return false;
                }
                open--;
            }
                
        }
        
        if (open == 0){
            return true;
        } else {
            return false;
        }
    }
}