/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 7/25/13
 * Time: 9:04 PM
 */

/**
 * Takes a number (h) in the input and prints hXh "X" using stars
 */

public class PrintX
{
    public static void main(String[] args) {
        int h = 20;
        //int h = getInputData(args[0]);

        for (int i = 0; i < h/2; i++){
            for (int space = 0; space <= i; space++){
                System.out.print(" ");
            }
            System.out.print("*");
            for (int space = 0; space <= h - 2 - i*2; space++){
                System.out.print(" ");
            }
            System.out.print("*");
            for (int space = 0; space <= i; space++){
                System.out.print(" ");
            }
            System.out.print("\n");
        }

        for (int space = 0; space <= h/2; space++){
            System.out.print(" ");
        }

        System.out.print("*");
        System.out.print("\n");


        for (int i = h/2 - 1; i >= 0; i--){
            for (int space = 0; space <= i; space++){
                System.out.print(" ");
            }
            System.out.print("*");
            for (int space = 0; space <= h - 2 - i*2; space++){
                System.out.print(" ");
            }
            System.out.print("*");
            for (int space = 0; space <= i; space++){
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
