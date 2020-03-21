import java.util.Random;

public class QuickSort {

    int swapCounter = 0; // global counter for run time analysis

    public void qsort(int[] array, int l, int r) {
        if (l < r) {
            int partitionIndex = partition(array, l, r);
            qsort(array, l, partitionIndex - 1);
            qsort(array, partitionIndex + 1, r);
        }
    }

    public int partition(int[] array, int l, int r) {
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

        // alternative partition
//        int pivot = array[r]; // pivot
//        int mid = r; // mid
//
//        for (int j = r-1; j >= l; j--) {
//            if (array[j] > pivot) {
//                mid--;
//                swap(array, mid, j);
//            }
//        }
//
//        array[r] = array[mid];
//        array[mid] = pivot;
//        return mid;
    }

    public void swap(int[] array, int i, int j) {
        swapCounter++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(int[] array) {
        System.out.print("A[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {4, 8, 5, 7, 2, 0, 9, 6, 1, 3};
//        int[] array2 = {34, 234, 23, 4, 23, 10, 99, 23, 31, 135, 132, 6, 45, 8};
//        int[] array3 = new int[100];
//        Random random = new Random();
//
//        for (int i = 0; i < 100; i++) {
//            array3[i] = random.nextInt(100);
//        }
//        quickSort.printArray(array3);
//        quickSort.qsort(array3, 0, array3.length - 1);
//        quickSort.printArray(array3);

        quickSort.qsort(array, 0, array.length - 1);
//        quickSort.qsort(array2, 0, array2.length - 1); // array 2

        System.out.println("Quicksort");
        quickSort.printArray(array);
        System.out.print("Number of swaps: " + quickSort.swapCounter);
    }
}
