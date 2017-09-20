package math;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/10/13
 * Time: 2:13 PM
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(countFactorial(1));
        System.out.println(countFactorial(2));
        System.out.println(countFactorial(5));
        System.out.println(countFactorial(10));
    }

    public static long countFactorial(int depth){
        if (depth == 1){
            return 1;
        }
        return countFactorial(depth - 1) * depth;
    }
}
