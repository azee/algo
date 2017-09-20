package lists;

/**
 * Created by azee on 20.09.17.
 */
public class IncreasingNumbers {
    public static void main(String[] args) {
        System.out.println(countIncreasing(1, 2, 3, 4, 3, 2, 1, 2, 3));
        System.out.println(countIncreasing(1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 5));
        System.out.println(countIncreasing(1, 2, 3));
        System.out.println(countIncreasing());
        System.out.println(countIncreasing(3,2,1));
    }


    private static int countIncreasing(int... values){
        int localRsult = 0;
        int result = 0;

        for (int i = 0; i < values.length - 1; i++){
            if (values[i] > values[i + 1]){
                localRsult = 0;
                i++;
            }
            while (i < values.length - 1 && values[i] < values[i + 1]){
                result = Math.max(result, ++localRsult);
                if (i == values.length - 2 && values[i] < values[i + 1]){
                    result = Math.max(result, ++localRsult);
                }
                i++;
            }
        }
        return result;
    }
}
