import java.util.*;

/**
 * Created by azee on 22.12.14.
 */
public class Main {
    public static void main(String... args) {
        count = 0;
        count("1313");
        System.out.println(count);

        count = 0;
        count("101");
        System.out.println(count);

    }

    static int count;

    public static void count(String value){
        int digit;
        if (value.length() == 0){
            count++;
            return;
        }

        digit = Integer.parseInt(value.substring(0, 1));
        if (digit > 0){
            count(value.substring(1));
        } else{
            return;
        }

        if (value.length() >= 2){
            digit = Integer.parseInt(value.substring(0, 2));
            if (digit <= 26 && digit > 0){
                count(value.substring(2));
            }
        }
    }


}
