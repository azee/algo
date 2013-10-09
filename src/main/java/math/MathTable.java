package math;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/10/13
 * Time: 2:15 AM
 */
public class MathTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= 10; j++){
                System.out.print(String.format ( "%4d", j * i ));
            }
            System.out.println("");
        }
    }

}
