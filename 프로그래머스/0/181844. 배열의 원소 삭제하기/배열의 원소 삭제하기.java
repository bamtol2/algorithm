class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for(int d : delete_list) set.add(d);
        for(int a : arr) if(!set.contains(a)) list.add(a);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}
