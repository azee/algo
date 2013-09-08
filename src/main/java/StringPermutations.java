import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 9/6/13
 * Time: 8:06 PM
 */

/**
 * Prints out all the permutations of a string in alphabetical order.
 * Input sample: hat
 * Output sample: aht,ath,hat,hta,tah,tha
 */

public class StringPermutations {
    //Using STDIO to provide logs. In real world better use log4j
    public static void main(String[] args) {
        //Getting input data
        List<String> inputData = new ArrayList<String>();
        try {
            inputData = getInputData(args[0]);

        } catch (Exception e) {
            System.out.println("Error occurred while reading a file \n" + e.getMessage());
        }

        for (String singleString : inputData){
            showPermutations(permutation(singleString));
        }
    }

    /**
     * Reads the file into list of strings
     * @return
     * @throws Exception
     */
    private static List<String> getInputData(String filePath) throws Exception {
        List<String> characters = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            String line = br.readLine();
            while (line != null) {
                characters.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return characters;
    }


    /**
     * Starting point to build permutations
     * @param str
     * @return
     */
    public static List<String> permutation(String str) {
        List<String> result = new ArrayList<String>();
        permutation("", str, result);
        return result;
    }

    /**
     * Recursive function based on floating prefix
     * @param prefix
     * @param str
     * @param permutations
     */
    private static void permutation(String prefix, String str, List<String> permutations) {
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), permutations);
        }
    }

    /**
     * Create a comma separated sorted string
     * @param permutations
     */
    private static void showPermutations(List<String> permutations){
        Collections.sort(permutations);
        String result = "";
        for (String permutation : permutations){
            result = result + permutation + ",";
        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
    }

}
