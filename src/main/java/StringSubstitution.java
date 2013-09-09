/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 9/9/13
 * Time: 6:22 PM
  */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
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

public class StringSubstitution {

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
            printResult(singleInputData.getTargetString(), singleInputData.getPatterns(), singleInputData.getReplaceTo());
        }

    }


    public static void printResult(String inputString, List<String> patterns, List<String> toSubstitute){
        List<Data> resultData = new LinkedList<Data>();
        AvailableData availableData = new AvailableData(inputString);
        resultData.add(availableData);

        for (int i = 0; i < patterns.size(); i++){
            for (int j = 0; j < resultData.size(); j++){
                if (!resultData.get(j).getValue().contains(patterns.get(i)) || !(resultData.get(j) instanceof AvailableData) ){
                    continue;
                }

                int index = resultData.get(j).getValue().indexOf(patterns.get(i));
                Data leftSubstring = new AvailableData(resultData.get(j).getValue().substring(0, index));
                Data middleSubstring = new ProcessedData(toSubstitute.get(i));
                Data rightSubstring = new AvailableData(resultData.get(j).getValue().substring(index + patterns.get(i).length(), resultData.get(j).getValue().length()));
                resultData = updateResultData(resultData, leftSubstring, middleSubstring, rightSubstring, j);
            }
        }

        System.out.println(formAString(resultData));
    }

    private static List<Data> updateResultData(List<Data> resultData, Data leftSubstring, Data middleSubstring, Data rightSubstring, int index){
        List<Data> newData = new LinkedList<Data>();
        for (int i = 0; i < resultData.size(); i++){
            if (i != index){
                newData.add(resultData.get(i));
            }else{
                newData.add(leftSubstring);
                newData.add(middleSubstring);
                newData.add(rightSubstring);
            }
        }
        return newData;
    }

    private static String formAString(List<Data> results){
        String result = "";
        for (Data data : results){
            result = result + data.getValue();
        }
        return result;
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


    /**
     * Inner Classes
     */

    private static class Data{
        private String value;

        public Data(String value){
            this.value = value;
        }

        public void setValue (String in){
            this.value = in;
        }

        public String getValue(){
            return value;
        }
    }

    private static class ProcessedData extends Data{
        public ProcessedData(String value){
            super(value);
        }

    }

    private static class AvailableData extends Data{
        public AvailableData(String value){
            super(value);
        }

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
