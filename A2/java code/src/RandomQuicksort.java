import java.util.Random;

/**
 * Implement the algorithm Randomized-Quicksort discussed in class and the variant
 * of Randomized-Quicksort given in Question 3. Report the running times of the two
 * algorithms for sorting n numbers with n = 2^i x 1000, i = 0; 1; 2; 3; 4; 5. Give your
 * suggestion on selecting k in practice (e.g., the k achieves the best running time in your
 * implementation).
 */
public class RandomQuicksort {

    int swapCounter = 0; // global counter for run time analysis

    void randomizedQuicksort(int[] array, int l, int r) {
        if (l < r) {
            int partitionIndex = partition(array, l, r);
            randomizedQuicksort(array, l, partitionIndex - 1);
            randomizedQuicksort(array, partitionIndex + 1, r);
        }
    }

    private int randomPartition(int l, int r) {
        Random random = new Random();
        int randomPartition = l + random.nextInt(r - l + 1);
        return randomPartition;
    }

    private int partition(int[] array, int l, int r) {
        int partition = randomPartition(l, r);

        swap(array, r, partition);
        swapCounter--;

        int pivot = array[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, r);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        swapCounter++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        RandomQuicksort randomQuicksort = new RandomQuicksort();
        // execution time measurements
        long startTime;
        long endTime;

        int arraySize = 32000;
        int[] array = new int[arraySize];
        Random random = new Random();
        random.setSeed(0);

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(10000);
        }

        System.out.println("n = " + arraySize);

        System.out.println("-----RANDOM QUICKSORT");
        startTime = System.nanoTime();
        randomQuicksort.randomizedQuicksort(array, 0, array.length - 1);
        endTime = System.nanoTime();

        System.out.println("-----Number of swaps: " + randomQuicksort.swapCounter);
        System.out.println("-----Execution time: " + String.format("%.6f",(float)(endTime - startTime)/1000000) + " ms\n");
    }
}