/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 9/9/13
 * Time: 6:22 PM
  */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, and a list of strings of positive length, F1,R1,F2,R2,...,FN,RN,
 * proceed to find in order the occurrences (left-to-right) of Fi in S and replace them with
 * Ri. All strings are over alphabet { 0, 1 }. Searching should consider only contiguous pieces of S
 * that have not been subject to replacements on prior iterations. An iteration
 * of the algorithm should not write over any previous replacement by the algorithm.
 *
 * Input sample: 10011011001;0110,1001,1001,0,10,11
 *
 * Output sample: 11100110
 *
 * For the curious, here are the transitions for the above example:
 * 10011011001 => 10100111001 [replacing 0110 with 1001]
 * => 10100110 [replacing 1001 with 0] => 11100110 [replacing 10 with 11].
 *
 */

public class StringSubstitutionRecursive {

    public static void main(String args[]){
        List<String> inputData = new ArrayList<String>();
        List<InputData> dataToProcess = new ArrayList<InputData>();
        try {
            inputData = getInputData(args[0]);

        } catch (Exception e) {
            System.out.println("Error occurred while reading a file \n" + e.getMessage());
        }

        for (String singleInputData : inputData){
            InputData preparedData = new InputData();
            preparedData.setTargetString(singleInputData.split(";")[0]);
            preparedData = parsePatterns(preparedData, singleInputData.split(";")[1]);
            dataToProcess.add(preparedData);
        }

        for(InputData singleInputData : dataToProcess){
            System.out.println(formString(singleInputData.getTargetString(), singleInputData.getPatterns(), singleInputData.getReplaceTo()));
        }

    }

    public static String formString(String input, List<String> patterns, List<String> toSubstitute){
        for (int i = 0; i < patterns.size(); i++){
            int index = input.indexOf(patterns.get(i));
            if (!input.contains(patterns.get(i))){
                continue;
            }
            String leftSubstring = input.substring(0, index);
            String middleSubstring = toSubstitute.get(i);
            String rightSubstring = input.substring(index + patterns.get(i).length(), input.length());

            input = formString(leftSubstring, patterns, toSubstitute) + middleSubstring +
                    formString(rightSubstring, patterns, toSubstitute);
            break;
        }

        return input;

    }

    private static InputData parsePatterns(InputData preparedData, String values){
        String[] splitted = values.split(",");
        for (int i = 0; i < splitted.length - 1; i = i + 2){
            preparedData.getPatterns().add(splitted[i]);
            preparedData.getReplaceTo().add(splitted[i + 1]);
        }
        return preparedData;
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


    private static class InputData{
        private String targetString;
        private List<String> patterns;
        private List<String> replaceTo;

        private String getTargetString() {
            return targetString;
        }

        private List<String> getPatterns() {
            if (patterns == null){
                this.patterns = new ArrayList<String>();
            }
            return patterns;
        }

        private List<String> getReplaceTo() {
            if (replaceTo == null){
                this.replaceTo = new ArrayList<String>();
            }
            return replaceTo;
        }

        private void setTargetString(String targetString) {
            this.targetString = targetString;
        }
    }
}
