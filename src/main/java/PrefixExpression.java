import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by azee on 30.12.15.
 */


/*Turn
* + 2 3 4
into
20
*/

public class PrefixExpression {

    public static void main(String[] args) throws Exception {
        for (String singleStr : getInputData(args[0])){
            performTask(singleStr);
        }
    }

    private static void performTask(String singleStr) {
        if (singleStr == null || singleStr.trim().length() == 0){
            System.out.println(0);
            return;
        }

        List<String> operations = new LinkedList<>();
        List<Integer> numbers = new LinkedList<>();
        for(String entry : singleStr.split(" ")){
            try{
                numbers.add(Integer.parseInt(entry.trim()));
            } catch (NumberFormatException e){
                operations.add(entry.trim());
            }
        }

        operations.add("=");
        Collections.reverse(operations);
        int result = 0;
        for (int i = 0; i < numbers.size(); i++){
            String operation = operations.get(i);
            if ("=".equals(operation)){
                result = numbers.get(i);
            }
            if("+".equals(operation)){
                result = result + numbers.get(i);
            }
            if("-".equals(operation)){
                result = result - numbers.get(i);
            }
            if("/".equals(operation) || "\\".equals(operation)){
                if (numbers.get(i) == 0){
                    System.out.println(0);
                    return;
                }
                result = result / numbers.get(i);
            }
            if("*".equals(operation) || "x".equals(operation)){
                result = result * numbers.get(i);
            }
        }
        System.out.println(result);
    }


    private static List<String> getInputData(String filePath) throws Exception {
        List<String> tasks = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            String line = br.readLine();
            while (line != null) {
                tasks.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return tasks;
    }
}
