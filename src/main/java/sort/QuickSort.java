package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/10/13
 * Time: 1:09 AM
 */
public class QuickSort {
    public static void main(String[] args){
        int[] testArray = {2, 4, 1, 5, 7, 9, 3, 6, 8};
        qSort(testArray, 0, testArray.length - 1);
        System.out.println(Arrays.toString(testArray));
    }

    public static void qSort(int[] array, int low, int high) {
        int i = low;
        int j = high;

        // Get the pivot element from the middle of the list
        int pivot = array[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (array[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (array[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            qSort(array, low, j);
        if (i < high)
            qSort(array, i, high);
    }
}
