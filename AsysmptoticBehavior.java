/**
 * Author:      Jack Pender, Emma Holt
 * Date:        October 2024
 * Class:       APCSA
 * Description: Creates 2 arrays, one random and one pre-sorted,
 *              then sorts the random array and searched for a target
 *              in an array. Finds the time it takes for each
 *              process and the time for the whole main method
 *              to execute.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AsymptoticBehavior {
    private static int target;
    private static double localTimeMillis;


    public static void main(String[] a) throws FileNotFoundException {
        double currentTimeMillis = System.currentTimeMillis();
        localTimeMillis = System.currentTimeMillis();

        int[] randArr   = generateRandomArray();
        System.out.println("Generating random array: " + localTimeMillis);

        int[] sortedArr = generateSortedArray();
        System.out.println("Generating sorted array: " + localTimeMillis);

        sortArray(randArr);
        System.out.println("Sorting random array: " + localTimeMillis);

        getTarget();
        binarySearch(randArr, target);
        System.out.println("Searching for target: " + localTimeMillis);

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;

        System.out.println("Main method: " + localTimeMillis);
    }

    /**
     * Generates an array with 10000 indexes with random integers in
     * each index
     * @return
     */
    public static int[] generateRandomArray() {
        double currentTimeMillis = System.currentTimeMillis();
        Random random = new Random();
        int[]  intArr = new int[10000];

        for(int i = 0; i < 10000; i++) {
            int randInt = random.nextInt(10000);
            intArr[i] = randInt;
        }

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
        return intArr;
    }

    /**
     * Generates an array with 10000 indexes with increasing integers
     * in each index
     * @return
     */
    public static int[] generateSortedArray() {
        double currentTimeMillis = System.currentTimeMillis();
        int[] intArr = new int[10000];

        for(int i = 0; i < 10000; i++) {
            intArr[i] = i;
        }

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
        return intArr;
    }

    /**
     * Sorts an array via bubble sort
     * @param arr
     */
    public static void sortArray(int[] arr) {
        double currentTimeMillis = System.currentTimeMillis();
        int n = arr.length;
        int temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < (n - i); j++){
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
    }

    /**
     * Finds a target integer from a text file
     * @throws FileNotFoundException
     */
    public static void getTarget() throws FileNotFoundException {
        double currentTimeMillis = System.currentTimeMillis();
        FileReader reader;
        String fileInputName = "data.txt";
        Scanner scan = null;

        scan = new Scanner(new BufferedReader(new FileReader(fileInputName)));
        int int1 = scan.nextInt();

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis = newTimeMillis - currentTimeMillis;
        target = int1;
    }

    /**
     * Performs a binary search (cutting a selection in half
     * until the target is found (or where it should be)
     * @param arr
     * @param target
     * @return
     */
    public static boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return true;

            if (arr[mid] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }

        double newTimeMillis = System.currentTimeMillis();
        localTimeMillis -= newTimeMillis;
        return false;
    }
}

/**
 * 1.
 *     I chose 10,000 for my n and the Big-Oh notation
 *     O(n) = n for random, O(n) = n for pre-sorted
 *     t1 = 0.0ms for random; t1 = 0.0ms for pre-sorted
 *     t2 = 15.0ms for random; t2 = 16.0ms for pre-sorted
 *     t2 / t1 for random and sorted is undefined,
 *     since the O(n) is linear then 100,000 processes
 *     gets increased to 1,000,000 processes making
 *     it take longer
 * 2.
 *     n is equal to the length of the array being sorted
 *     and O(n) = n^2
 *     t1 = 104.0
 *     t2 = 23558.0ms
 *     t2 / t1 = 221.2ms, this means that t1 is 221.2 times faster
 *     than t2
 * 3.
 *     n is the same as the array being searched (100000)
 *     t1 = 31.0ms
 *     t2 = 41.0ms
 *     t2 / t1 = 1.32ms, this means that t1 is only 1.32 times faster
 *     than t2 which means that t1 and t2 are relatively similar processes
 *     (their complexity are both O(n) = logn so they are both going
 *     to take similar amounts of time even though t2 has an n value that
 *     is 10 times higher)
 * 4.
 *     Main Method: No
 *     Generate Random Array: No
 *     Generate Sorted Array: No
 *     Sort Random Array: No
 *     Search Array: No
 * 5.
 *     The main issue is that very short processes
 *     take such short time that the computer rounds
 *     the time the process takes down to 0.0. Also,
 *     Big-Oh is the worst case scenario, so it doesn't
 *     totally match up with the actual times.
 */
