package strings;

/**
 * Created by azee on 21.05.16.
 */
public class InterleavingStrings {

    public static void main(String... args){
        System.out.println("Direct child");
        System.out.println(interleave("alongparentstring", "ren"));
        System.out.println(interleave("alongparentstring", ""));

        System.out.println("\n\nDirect parent");
        System.out.println(interleaveParent("alongparentstring", "ren"));
        System.out.println(interleaveParent("alongpaentstring", "ren"));

        System.out.println("\n\nNonSeq");
        System.out.println(interleaveNonSeq("alongparentstring", "ren"));
        System.out.println(interleaveNonSeq("alongparentstring", ""));
        System.out.println(interleaveNonSeq("alongparentstring", "ren"));
        System.out.println(interleaveNonSeq("alongpaentstring", "ren"));
        System.out.println(interleaveNonSeq("adrobetns", "ren")); // True
    }

    public static boolean interleaveNonSeq(String str1, String str2){
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0){
            return false;
        }
        int i;
        int j;
        for (int elem = 0; elem < str1.length(); elem++){
            i = elem;
            j = 0;
            while (i < str1.length()){
                if (str1.charAt(i) == str2.charAt(j)){
                    j++;
                    if (j == str2.length() - 1){
                        return true;
                    }
                }
                i++;
            }
        }
        return false;


    }

    public static boolean interleave(String str1, String str2){
        for (int i = 0; i < str2.length(); i++){
            for (int j = i; j < str2.length(); j++){
                if (str1.contains(str2.substring(i, j))){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean interleaveParent(String str1, String str2){
        for (int i = 0; i < str1.length(); i++){
            for (int j = i; j < str1.length(); j++){
                String tmpStr = String.valueOf(str1.substring(i, j));
                if (tmpStr.contains(str2)){
                    return true;
                }
            }
        }
        return false;
    }
}
