package strings; /**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 7/25/13
 * Time: 9:04 PM
 */

/**
 * Reverse a string using a recursive algorithm
 */

public class ReverseString{
    public static void main(String[] args) {
        System.out.print(reverse("SomeString"));
    }

    public static String reverse(String str) {
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        String reversed = reverse(str.substring(1)) + str.charAt(0);
        return reversed;
    }

}
