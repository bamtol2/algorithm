class Solution {
    public String solution(int age) {
        String[] arr = {"a","b","c","d","e","f","g","h","i","j"};
        StringBuilder sb = new StringBuilder();
        
        for (char c : String.valueOf(age).toCharArray()) {
            sb.append(arr[c - '0']);
        }
        
        return sb.toString();
    }
}