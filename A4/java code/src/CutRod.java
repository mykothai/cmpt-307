/**
 * Dynamic programming rod cutting algorithm comparison and analysis.
 */
public class CutRod {
    static final int NEG_INFINITY = Integer.MIN_VALUE;

    /**
     * Top-down recursive algorithm for rod-cutting. O(2^n)
     * @param p array of prices for specific rod lengths
     * @param n rod length
     * @return maximum revenue
     */
    public int cutRod(int[] p, int n) {
        if (n == 0) {
            return 0;
        }

        int revenue = NEG_INFINITY;

        for (int i = 0; i < n; i++) {
            revenue = Math.max(revenue, p[i] + cutRod(p, n - i - 1));
        }

        return revenue;
    }

    /**
     * Dynamic programming approach.
     * Recursive top-down with memoization for cut rod. O(n^2)
     * @param p array of prices for specific rod lengths
     * @param n rod length
     * @return maximum revenue
     */
    public int memoizedCutRod(int[] p, int n) {
        int[] revenueArray = new int[n + 1];

        for (int i = 0; i < revenueArray.length; i++) {
            revenueArray[i] = NEG_INFINITY;
        }

        return memoizedCutRodAux(p, n, revenueArray);
    }

    private int memoizedCutRodAux(int[] p, int n, int[] revenueArray) {
        if (revenueArray[n] >= 0) {
            return revenueArray[n];
        }

        int revenue = NEG_INFINITY;

        if (n == 0) {
            revenue = 0;
        } else {
            for (int i = 0; i < n; i++) {
                revenue = Math.max(revenue, p[i] + memoizedCutRodAux(p, n - i - 1, revenueArray));
            }
        }

        revenueArray[n] = revenue;

        return revenue;
    }

    /**
     * Dynamic programming approach.
     * Bottom-up with memoization for cut rod. O(n^2)
     * @param p array of prices for specific rod lengths
     * @param n rod length
     * @return max stored revenue
     */
    public int bottomUpCutRod(int[] p, int n) {
        int[] revenueArray = new int[n + 1];
        revenueArray[0] = 0;

        int revenue = NEG_INFINITY;

        for (int i = 1; i <= n; i++) {
            revenueArray[i] = NEG_INFINITY;
            for (int j = 0; j < i; j++) {
                revenue = Math.max(revenue, p[j] + revenueArray[i - j - 1]);
            }

            revenueArray[i] = revenue;
        }

        return revenueArray[n];
    }

    public int[][] extendedBottomUpCutRod(int[] p, int n) {
        int[] revenueArray = new int[n + 1];
        int[] size = new int[n + 1];

        revenueArray[0] = 0;
        int revenue;

        for (int i = 1; i <= n; i++) {
            revenue = NEG_INFINITY;
            for (int j = 0; j < i; j++) {
                if (revenue < p[j] + revenueArray[i - j - 1]) {
                    revenue = p[j] + revenueArray[i - j - 1];
                    size[i] = j + 1;
                }
            }
            revenueArray[i] = revenue;
        }

        return new int[][]{revenueArray, size};
    }

    public void printCutRodSolution(int[] p, int n) {
        int[][] rs = extendedBottomUpCutRod(p, n);
        int[] size = rs[1];
        while (n > 0) {
            System.out.println(size[n]);
            n = n - size[n];
        }
    }
}
