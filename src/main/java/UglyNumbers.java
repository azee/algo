import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/16/13
 * Time: 2:51 AM
 */

//Once upon a time in a strange situation, people called a number
// ugly if it was divisible by any of the one-digit primes (2, 3, 5 or 7).
// Thus, 14 is ugly, but 13 is fine. 39 is ugly, but 121 is not. Note that 0 is ugly.
// Also note that negative numbers can also be ugly: -14 and -39 are examples of such numbers.
public class UglyNumbers {
    public static void main(String[] args) {
        printList(getStringVariant("12345"));
    }

    /**
     * Reads the file into list of strings
     * @return
     * @throws Exception
     */
    private static List<String> getInputData(String filePath) throws Exception {
        List<String> values = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            String line = br.readLine();
            while (line != null) {
                values.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return values;
    }



    public static List<Integer> getStringVariant(String number){
        List<Integer> results = new ArrayList<Integer>();
        results.add(Integer.parseInt(number));
        for(int i = 1; i < number.length(); i++){
            for(Integer subResult : getStringVariant(number.substring(i, number.length()))){
                results.add(Integer.parseInt(number.substring(0, i)) + subResult);
            }
            for(Integer subResult : getStringVariant(number.substring(i, number.length()))){
                results.add(Integer.parseInt(number.substring(0, i)) - subResult);
            }
        }
        return results;
    }

    public static boolean isUgly(int value){
        if(Math.abs(value % 2) == 0 || Math.abs(value % 3) == 0 || Math.abs(value % 5) == 0 || Math.abs(value % 7) == 0 || value == 0){
            return true;
        }
        return false;
    }


    public static void printList(List<Integer> values) {
        int counter = 0;
        for(Integer value : values){
            if(isUgly(value)){
                counter ++;
            }
        }
        System.out.println(counter);

    }
}
