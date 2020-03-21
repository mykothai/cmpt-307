public class Main extends CutRod {

    public static void main(String[] args) {
        CutRod cutRods = new CutRod();

        // execution time measurements
        long startTime = 0;
        long endTime = 0;

        int[] nArray = {5, 10, 15, 20, 25, 30};
        int[] priceArray = {
                1, 5, 8, 9, 10, 17, 17, 20, 24, 30,
                32, 35, 38, 49, 50, 57, 67, 80, 84, 90,
                91, 95, 98, 99, 100, 107, 120, 120, 124, 125
        };

        System.out.println("----- Top Down Cut Rod -----\n");
        for (int n : nArray) {
            startTime = System.nanoTime();
            System.out.println("Revenue: " + cutRods.cutRod(priceArray, n));
            endTime = System.nanoTime();
            System.out.println(
                "n: " +
                n +
                "\n" +
                "Execution time: " +
                String.format("%.6f", (float)(endTime - startTime) / 1000000) +
                " ms\n"
            );
        }

        System.out.println("----- Memoized Cut Rod -----\n");
        for (int n : nArray) {
            startTime = System.nanoTime();
            System.out.println("Revenue: " + cutRods.memoizedCutRod(priceArray, n));
            endTime = System.nanoTime();
            System.out.println(
                "n: " +
                n +
                "\n" +
                "Execution time: " +
                String.format("%.6f", (float)(endTime - startTime) / 1000000) +
                " ms\n"
            );
        }

        System.out.println("----- Bottom-Up Cut Rod -----\n");
        for (int n : nArray) {
            startTime = System.nanoTime();
            System.out.println("Revenue: " + cutRods.bottomUpCutRod(priceArray, n));
            endTime = System.nanoTime();
            System.out.println(
                "n: " +
                n +
                "\n" +
                "Execution time: " +
                String.format("%.6f", (float)(endTime - startTime) / 1000000) +
                " ms\n"
            );
        }
    }
}
