package bits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/15/13
 * Time: 1:41 AM
 */
public class IntToBits {
    public static void main(String ...args){
        int value = 44;

        printBitsRecursive(value);
        List<Integer> bits = new ArrayList<Integer>();
        while(value >= 1){
            bits.add(value % 2);
            value = value / 2;
        }
        printBits(bits);

    }

    public static void printBits(List<Integer> bits){
        Collections.reverse(bits);
        for(int bit : bits){
            System.out.println(bit);
        }
    }

    public static void printBitsRecursive(int value){
        if (value < 1) {
            return;
        }
        printBitsRecursive(value / 2);
        System.out.println(value % 2);
    }

    public static int countBits(int value){
        if (value < 1) {
            return 0;
        }
        return countBits(value / 2) + (value % 2);
    }
}
