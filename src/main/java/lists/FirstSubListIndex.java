package lists;

/**
 * Created by azee on 08.09.16.
 */
public class FirstSubListIndex {

    public static void main(String... args){
        System.out.println(find(new int[]{1, 2, 3}, new int[]{2, 3}));
        System.out.println(find(new int[]{1, 2, 3, 4}, new int[]{3, 4}));
        System.out.println(find(new int[]{1, 2, 3}, new int[]{1}));
        System.out.println(find(new int[]{1, 2, 3}, new int[]{3}));

        System.out.println(find(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5}));
        System.out.println(find(new int[]{1, 2, 3}, new int[]{3, 3}));
        System.out.println(find(new int[]{1, 2, 3}, new int[]{}));
        System.out.println(find(new int[]{}, new int[]{3}));
    }

    public static int find(int[] arr, int[] sub){
        int result = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr.length - i < sub.length){
                return -1;
            }
            for (int j = 0; j < sub.length; j++){
                result = i;
                if (arr[j + i] != sub[j]){
                    result = -1;
                    break;
                }
                if (result != -1){
                    return result;
                }
            }
        }
        return result;
    }

}
