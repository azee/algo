public class LongestNumberSubarrayInSortedArray {

    public static void main(String... args){
        int daata[] = {5 ,5 ,5, 7, 7, 7, 7, 7, 9, 9, 9, 9, 10, 10, 10};
        System.out.println(getLargerstDuplicates(daata));

    }

    private static int getLargerstDuplicates(int[] daata) {
        int maxLength = 0;
        int result = 0;

        for (int i = 0; i < daata.length; i++){
            int j = i;
            while (j < daata.length && daata[j] == daata[i]){
                j++;
                if (maxLength < j - i){
                    maxLength = j - i;
                    result = daata[i];
                }
            }

        }
        return result;
    }



}
