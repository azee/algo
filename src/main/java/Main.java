import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/15/13
 * Time: 12:28 AM
 */
public class Main {

    public static void main(String[] args) {
        //Getting input data
        List<String> inputData = new ArrayList<String>();
        try {
            inputData = getInputData(args[0]);

        } catch (Exception e) {
            System.out.println("Error occurred while reading a file \n" + e.getMessage());
        }

        for (String singleLine : inputData){
            printList(getStringVariant(singleLine));
        }
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



    public static List<Long> getStringVariant(String number){
        List<Long> results = new ArrayList<Long>();
        results.add(Long.parseLong(number));
        for(int i = 1; i < number.length(); i++){
            for(Long subResult : getStringVariant(number.substring(i, number.length()))){
                results.add(Integer.parseInt(number.substring(0, i)) + subResult);
            }
            for(Long subResult : getStringVariant(number.substring(i, number.length()))){
                results.add(Integer.parseInt(number.substring(0, i)) - subResult);
            }
        }
        return results;
    }

    public static boolean isUgly(Long value){
        if(Math.abs(value % 2) == 0 || Math.abs(value % 3) == 0 || Math.abs(value % 5) == 0 || Math.abs(value % 7) == 0 || value == 0){
            return true;
        }
        return false;
    }


    public static void printList(List<Long> values) {
        int counter = 0;
        for(Long value : values){
            if(isUgly(value)){
                counter ++;
            }
        }
        System.out.println(counter);

    }


}
