import java.text.DecimalFormat;
import java.util.Random;

public class QuicksortRuntimeAnalysis {

    public static RandomQuicksort randomQuicksort = new RandomQuicksort();
    public static RandomQuicksortVariant randomQuicksortVariant = new RandomQuicksortVariant();

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // set up random number generator
        Random random = new Random();
        random.setSeed(0); // seed to keep generated array consistent between both QS algorithms

        double arraySize;
        int ntimes = 6;
        int k = 300;
        // execution time measurements
        long startTime;
        long endTime;

        // create arrays
        for (int i = 0; i < ntimes; i++) {
            arraySize = Math.pow(2, i) * 1000;
            int[] array = new int[(int) arraySize];

            for (int j = 0; j < array.length; j++) {
                array[j] = random.nextInt(10000);
            }

            System.out.println("n = " + arraySize);

            System.out.println("-----RANDOM QUICKSORT");
            startTime = System.nanoTime();
            randomQuicksort.randomizedQuicksort(array, 0, array.length - 1);
            endTime = System.nanoTime();
//            printArray(array);
            System.out.println("-----Number of swaps: " + randomQuicksort.swapCounter);
            System.out.println("-----Execution time: " + String.format("%.6f", (float)(endTime - startTime) / 1000000) + " ms\n");

            System.out.println("-----VARIANT");
            startTime = System.nanoTime();
            randomQuicksortVariant.randomizedQuicksort(array, 0, array.length - 1, k);
            endTime = System.nanoTime();
//            printArray(array);
            System.out.println("-----Number of swaps: " + randomQuicksortVariant.swapCounter);
            System.out.println("-----Execution time: " + String.format("%.6f", (float)(endTime - startTime) / 1000000) + " ms\n");
        }
    }
}
