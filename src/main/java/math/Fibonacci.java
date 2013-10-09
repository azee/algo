package math;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/10/13
 * Time: 1:39 AM
 */
public class Fibonacci {
    public static void main(String[] args) {
        int depth = 10;
        System.out.print(fibonacci(0, 1, depth));
    }

    public static long fibonacci(long val1, long val2, int depth){
        long result = 0;
        for (int i = 0; i < depth; i++){
            result = val1 + val2;
            val1 = val2;
            val2 = result;
        }
        return result;
    }

}

