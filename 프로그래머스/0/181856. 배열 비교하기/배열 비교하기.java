class Solution {
    public int solution(int[] arr1, int[] arr2) {

        if (arr1.length > arr2.length) return 1;
        if (arr1.length < arr2.length) return -1;

        int sum1 = 0, sum2 = 0;
        for (int n : arr1) sum1 += n;
        for (int n : arr2) sum2 += n;

        if (sum1 > sum2) return 1;
        if (sum1 < sum2) return -1;
        return 0;
    }
}
