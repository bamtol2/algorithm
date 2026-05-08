class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.split(" \\+ ");
        
        int xSum = 0;
        int numSum = 0;
        
        for (String s : arr) {
            if (s.contains("x")) {
                if (s.equals("x")) {
                    xSum += 1;
                } else {
                    xSum += Integer.parseInt(s.replace("x", ""));
                }
            } else {
                numSum += Integer.parseInt(s);
            }
        }
        
        if (xSum == 0) {
            return String.valueOf(numSum);
        } else if (numSum == 0) {
            return xSum == 1 ? "x" : xSum + "x";
        } else {
            return (xSum == 1 ? "x" : xSum + "x") + " + " + numSum;
        }
    }
}