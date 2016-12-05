package strings;

/**
 * Created by azee on 08.09.16.
 */
public class ValiateAscii {
    public static void main(String... args){
        int top = (int)' ';
        int bottom = (int)'~';

        validate(top, bottom, "Yoyoyo");
        validate(top, bottom, "Maaa!@#$%");
        validate(top, bottom, new String(new char[]{'a', 18}));
    }

    public static void validate(int top, int bottom, String input){
        for (char ch : input.toCharArray()){
            if ((int)ch < top || (int)ch > bottom){
                System.out.println("Error");
                return;
            }
        }
        System.out.println(input);
    }
}
