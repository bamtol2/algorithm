class Solution {
    public int solution(int[] num_list) {
        int length = num_list.length;
        
        if (length >= 11){
            int sum = 0;
            for (int num : num_list){
                sum += num;
            }
            return sum;
        } else {
            int product = 1;
            for (int num : num_list){
                product *= num;
            }
            return product;
        }
    }
}