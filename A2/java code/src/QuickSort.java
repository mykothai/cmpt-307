public class QuickSort {

    private int swapCounter = 0; // global counter for run time analysis

    private void qsort(int[] array, int l, int r) {
        if (l < r) {
            int partitionIndex = partition(array, l, r);
            qsort(array, l, partitionIndex - 1);
            qsort(array, partitionIndex + 1, r);
        }
    }

    private int partition(int[] array, int l, int r) {
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

    private void printArray(int[] array) {
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

        quickSort.qsort(array, 0, array.length - 1);

        System.out.println("Quicksort");
        quickSort.printArray(array);
        System.out.print("Number of swaps: " + quickSort.swapCounter);
    }
}
