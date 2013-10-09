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
        int x = array[(low+high)/2];
        do {
            while(array[i] < x) ++i;
            while(array[j] > x) --j;
            if(i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i ++ ; j --;
            }
        } while(i <= j);

        if(low < j) qSort(array, low, j);
        if(i < high) qSort(array, i, high);
    }
}
