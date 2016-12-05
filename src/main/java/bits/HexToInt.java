package bits;

/**
 * Created by azee on 18.05.16.
 */
public class HexToInt {
    public static void main(String... args){
        System.out.println(decimal2Custom7(7));
    }

    public static int hex2decimal(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }

    public static String decimal2hex(int d) {
        String digits = "0123456789ABCDEF";
        if (d == 0) return "0";
        String hex = "";
        while (d > 0) {
            int digit = d % 16;                // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            d = d / 16;
        }
        return hex;
    }

    public static String decimal2Custom7(int d) {
        String digits = "CuStOmS";
        if (d == 0) return "0";
        String hex = "";
        while (d > 0) {
            int digit = d % 7;                // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            d = d / 7;
        }
        return hex;
    }



}
