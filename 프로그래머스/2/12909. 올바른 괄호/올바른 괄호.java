class Solution {
    boolean solution(String s) {
        int length = s.length();
        
        if(s.charAt(0) == ')'){
            return false;
        }
        
        else if (s.charAt(length-1) == '('){
            return false;
        }
        
        int leftCount = 0;
        int rightCount = 0;
        
        for (int i = 0; i < length; i++){
            if(s.charAt(i) == ')'){
                rightCount += 1;
            } else if (s.charAt(i) == '('){
                leftCount += 1;
            }
            
            if(rightCount > leftCount){
                return false;
            }
        }

        if (rightCount == leftCount){
            return true;
        } else {
            return false;
        }
        
    }
}