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
        System.out.println(fibonacci(0, 1, depth));
        System.out.println(fibonacciRecursive(depth));
    }

    public static long fibonacci(long val1, long val2, int depth){
        long sum;
        for (int i = 0; i < depth; i++){
            sum = val1 + val2;
            val1 = val2;
            val2 = sum;
        }
        return val1;
    }

    private static int fibonacciRecursive(int depth) {
        if (depth <= 0) {
            return 0;
        } else if (depth == 1 || depth == 2) {
            return 1;
        } else {
            return fibonacciRecursive(depth - 1) + fibonacciRecursive(depth - 2);
        }
    }
}

