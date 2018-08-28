public class LongestDoubleOccuredSubstring {

    public static void main(String... args){
        System.out.println(getLargerstDoubleSubstring("banana"));

    }


    public static String getLargerstDoubleSubstring(String source){
        int max = 0;
        String result = null;
        for (int i = 0; i < source.length(); i++){
            for (int j = i + 1; j < source.length(); j++){
                String toFind = source.substring(i, j);
                if (source.lastIndexOf(toFind) != i && max < j - i){
                    max = j - i;
                    result = toFind;
                }
            }
        }
        return result;
    }
}
