public class InsertionSort {
    private void sort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j - 1, j);
                j--;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {4, 8, 5, 7, 2, 0, 9, 6, 1, 3};
        insertionSort.printArray(array);
        insertionSort.sort(array);
        insertionSort.printArray(array);
    }
}
