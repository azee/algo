package math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 9/7/13
 * Time: 3:44 AM
 */

/**
 * A program should accept as its first argument a path to a filename.
 * Each line in this file is one test case. Each test case will contain an integer n < 4,294,967,295. E.g.
 * 10
 * 20
 * 100
 *
 * Output sample:
 * 2,3,5,7
 * 2,3,5,7,11,13,17,19
 * 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
 */
public class Prime {
    public static void main(String[] args) {
        List<String> inputData = new ArrayList<String>();
        try {
            inputData = getInputData(args[0]);
        } catch (Exception e) {
            System.out.println("Error occurred while reading a file \n" + e.getMessage());
        }

        for (String singleData : inputData){
            if ("".equals(singleData)){
                continue;
            }
            System.out.println(printPrimes(singleData));
        }
    }

    public static String printPrimes(String input) {
        String result = "";
        Integer number = Integer.parseInt(input);
        for (int i = 2; i < number; i++){
            if (isPrime(i)){
                result = result + i + ",";
            }
        }
        return result.substring(0, result.length() - 1);
    }


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

    public static boolean isPrime(int number){
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                return false; //number is divisible so its not prime
            }
        }
        return true; //number is prime
    }


}
