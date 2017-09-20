package strings;

/**
 * Created by azee on 14.01.15.
 * 2--b
 ...
 26--z
 given a digit , return the count of the possible output
 eg. '1313' --- 4
 acac mac mm acm
 '101' --1
 ja
 cannot discard any digit
 */
public class PossibleDigitOutputs {
    int count;

    public void count(String value){
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
