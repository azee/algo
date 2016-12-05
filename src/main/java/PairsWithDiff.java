import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by azee on 30.08.16.
 */
public class PairsWithDiff {

    public static void main(String... args){
        calc(new int[]{1, 2, 4, 5, 7, 8, 12, 15, 2, 1, 6}, 2);
    }

    public static void calc(int[] numbers, int diff){
        Map<Integer, Integer> diffs = new LinkedHashMap<>();
        for (int number : numbers){
            diffs.put(number - diff, number);
        }
        for (int number : numbers){
            if (diffs.containsKey(number)){
                System.out.println(String.format("%s-%s", number, diffs.get(number)));
            }
        }
    }
}
