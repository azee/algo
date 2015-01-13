import java.util.*;

/**
 * Created by azee on 22.12.14.
 */
public class Main {
    public static void main(String... args) {
        int source = 16;

        for (int i = 2; i < source; i++){
            if ((i * i) >= source){
                System.out.println(i);
                break;
            }
        }

    }


}
