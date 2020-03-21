import java.util.Random;

/**
 * CMPT 307 Assignment 2 - Textbook problem 5-1
 * Searching an unsorted array problem: Given an array of n elements which are not sorted
 * and a value x, nd the index i such that A[i] = x. A randomized algorithm Random-
 * Search for the problem is as follows: select a number i from f1; ::; ng independently
 * and uniformly; if A[i] = x then return i and terminate; otherwise repeat the above
 * process until the i with A[i] = x is found or A[i] 6= x for every i = 1; ::; n is concluded.
 *
 * (a) Write a pseudo-code for Random-Search.
 * (b) Assume there is exactly one i such that A[i] = x. What is the expected number of
 * checks of A[i] = x Random-Search performs before terminates.
 *
 * Answer:
 * The number of expected checks of A[i] = x is equal to the number of times a random number is generated divided by the
 */
public class RandomSearch {

    public int search(int target, int[] array) {
        int[] indexTrack = new int[array.length];
        int counter = 0;    // checks of tracked array is full
        int numberOfIterations = 0; // testing run time only

        // get random number
        int max = array.length;
        int min = 0;

        Random random = new Random();
        int i = min + random.nextInt(max);

        while (counter < array.length) {
            numberOfIterations++;   // testing only

            if (array[i] == target) {
//                return numberOfIterations; // testing average run time, remove
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
