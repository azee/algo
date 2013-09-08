import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 9/6/13
 * Time: 8:48 PM
 */

/*
 * Determine the longest common subsequence between the two strings.
 * Each string can have a maximum length of 50 characters).
 * This subsequence need not be contiguous.
 * The input file may contain empty lines, these need to be ignored.
 * Input sample:
 * XMJYAUZ;MZJAWXU
 * Result samle:
 * MJAU
 */

public class LongestSubSeq {
    public static void main(String[] args) {
        List<String> inputData = new ArrayList<String>();
        try {
            inputData = getInputData(args[0]);
        } catch (Exception e) {
            System.out.println("Error occurred while reading a file \n" + e.getMessage());
        }

        for (String singleData : inputData){
            List<String> strings = Arrays.asList(singleData.split(";"));
            if (strings.size() < 2){
                continue;
            }
            System.out.println(searchInStrings(strings).trim());
        }
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

    private static String searchInStrings(List<String> strings){
        return lcs(strings.get(0), strings.get(1));
    }

    public static String lcs(String firstString, String secondString) {
        int[][] lengths = new int[firstString.length() + 1][secondString.length() + 1];

        for (int i = 0; i < firstString.length(); i++)
            for (int j = 0; j < secondString.length(); j++)
                if (firstString.charAt(i) == secondString.charAt(j))
                    lengths[i+1][j+1] = lengths[i][j] + 1;
                else
                    lengths[i+1][j+1] =
                            Math.max(lengths[i+1][j], lengths[i][j+1]);

        StringBuffer sb = new StringBuffer();
        for (int x = firstString.length(), y = secondString.length(); x != 0 && y != 0; ) {
            if (lengths[x][y] == lengths[x-1][y])
                x--;
            else if (lengths[x][y] == lengths[x][y-1])
                y--;
            else {
                assert firstString.charAt(x-1) == secondString.charAt(y-1);
                sb.append(firstString.charAt(x-1));
                x--;
                y--;
            }
        }

        return sb.reverse().toString();
    }







}
