class Solution {
    public int solution(int[] arr) {
        int x = 0;

        while (true) {
            boolean same = true;

            for (int i = 0; i < arr.length; i++) {
                int before = arr[i];

                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                }

                if (before != arr[i]) {
                    same = false;
                }
            }

            if (same) return x;
            x++;
        }
    }
}
