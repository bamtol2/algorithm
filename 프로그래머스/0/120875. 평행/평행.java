class Solution {
    public int solution(int[][] dots) {

        // (0,1) - (2,3)
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) {
            return 1;
        }

        // (0,2) - (1,3)
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) {
            return 1;
        }

        // (0,3) - (1,2)
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) {
            return 1;
        }

        return 0;
    }

    public boolean isParallel(int[] a, int[] b, int[] c, int[] d) {

        return (b[1] - a[1]) * (d[0] - c[0])
                == (d[1] - c[1]) * (b[0] - a[0]);
    }
}