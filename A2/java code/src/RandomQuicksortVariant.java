import java.util.Random;

/**
 * Randomized quicksort that stops at n/k and uses insertion sort for the remainder
 */
public class RandomQuicksortVariant {

    int swapCounter = 0; // global counter for run time analysis

    public void randomizedQuicksort(int[] array, int l, int r, int k) {

//        if (l < r) {
//            int partitionIndex = randomPartition(array, l, r);
//
//            if (partitionIndex - l >= k) { // swapped inequality
//                randomizedQuicksort(array, l, partitionIndex - 1, k);
//            }
//
//            if (r - partitionIndex >= k) { // swapped inequality
//                randomizedQuicksort(array, partitionIndex + 1, r, k);
//            }
//        }
//        insertionSort(array, l, r);

        if (l < r) {
            if (r - l < k) {
                insertionSort(array, l, r);
            } else {
                int partitionIndex = partition(array, l, r);
                randomizedQuicksort(array, l, partitionIndex - 1, k);
                randomizedQuicksort(array, partitionIndex + 1, r, k);
            }
        }
    }

    public int randomPartition(int l, int r) {
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

    void insertionSort(int[] array, int l, int r) {
        int i, j, key;

        for (j = l + 1; j < r; j++) {
            key = array[j];
            for (i = j - 1; i >= l && array[i] > key; i--) {
                array[i + 1] = array[i];
            }
            array[i + 1] = key;
            swapCounter++;
        }
    }

    public void swap(int[] array, int i, int j) {
        swapCounter++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(int[] array) {
        for (int index : array) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RandomQuicksortVariant randomQuicksortVariant = new RandomQuicksortVariant();
        // execution time measurements
        long startTime = 0;
        long endTime = 0;

        int k = 0;
        double arraySize;
        int iterations = 1000;
        Random random = new Random();
        random.setSeed(0);

        for (int i = 0; i < 6; i++) {
            arraySize = Math.pow(2, i) * 1000;
            int[] array = new int[(int)arraySize];

            for (int j = 0; j < array.length; j++) {
                array[j] = random.nextInt(10000);
            }

            for (int m = 0; m < iterations; m++) {
                int[] newArray = array.clone();
                startTime = System.nanoTime();
                randomQuicksortVariant.randomizedQuicksort(newArray, 0, newArray.length - 1, k);
                endTime = System.nanoTime();
            }

            System.out.println("n = " + arraySize);
            System.out.println("-----VARIANT");
            System.out.println("-----Average # of swaps: " + randomQuicksortVariant.swapCounter / iterations);
            System.out.println("-----Average execution time: " + String.format("%.6f", (float) ((endTime - startTime)) / 1000000) + " ms\n");
//            randomQuicksortVariant.printArray(array);
        }
    }
}
