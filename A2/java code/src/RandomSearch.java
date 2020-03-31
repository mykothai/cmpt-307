import java.util.Random;

/**
 * Randomly searches an index i in the array for a target and
 * Keeps track of whether an index has been searched.
 */
public class RandomSearch {

    public int search(int target, int[] array) {
        int[] indexTrack = new int[array.length];
        int counter = 0;    // checks if tracked array is full

        // get random number
        int max = array.length;
        int min = 0;

        Random random = new Random();
        int i = min + random.nextInt(max);

        while (counter < array.length) {
            if (array[i] == target) {
                return i;
            }

            if (indexTrack[i] == 0) {
                indexTrack[i] = 1;
                counter++;
            }

            i = min + random.nextInt(max);
        }
        return -1;
//        return numberOfIterations; // run time testing for no matches
    }

    public static void main(String[] args) {
        int iterations = 1000000;
        int totalRunTime = 0;
        RandomSearch randomSearch = new RandomSearch();
        int[] array = {4, 8, 5, 7, 2, 0, 9, 6, 1, 3};
        for (int i = 0; i < iterations; i++) { // loop is for testing run time
            System.out.println(randomSearch.search(3, array));
//            totalRunTime = totalRunTime + randomSearch.search(30, array); //testing run time
        }

//        System.out.println(totalRunTime/iterations); // testing run time
    }
}
