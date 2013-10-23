package structures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 9/5/13
 * Time: 2:45 PM
 */

/**
 * Write a program to determine the Mth to last element of a list.
 * The first argument will be a text file containing a series of space delimited
 * characters followed by an integer representing a index into the list (1 based), one per line.
 * E.g.:
 * a b c d 4
 * e f g h 2
 * Output sample:
 * a
 * g
 */

public class MthElement {

    //Using STDIO to provide logs. In real world better use log4j
    public static void main(String[] args) {
        //Getting input data
        List<String> inputData = new ArrayList<String>();
        try {
             inputData = getInputData(args[0]);

        } catch (Exception e) {
            System.out.println("Error occurred while reading a file \n" + e.getMessage());
        }

        //Iterating through all lines in the file.
        // Can be used in getInputData() if files are expected to be large
        for (String inputString : inputData){
            //Getting an list of chars
            List<String> chars = Arrays.asList(inputString.split(" "));

            //Getting an index. Skip if NaN.
            String lastChar = chars.get(chars.size() - 1);
            int index;
            try {
                index = Integer.parseInt(lastChar);
            } catch (Exception e){
                continue;
            }

            //Skip if index is out of range
            if (index > chars.size() - 1 || index <= 0){
                continue;
            }

            System.out.println(chars.get(chars.size() - index - 1));
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

}

