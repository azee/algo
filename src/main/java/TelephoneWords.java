import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/15/13
 * Time: 6:42 PM
 */
public class TelephoneWords {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("0", Arrays.asList(new String[]{"0"}));
        map.put("1", Arrays.asList(new String[]{"1"}));
        map.put("2", Arrays.asList(new String[]{"a", "b", "c"}));
        map.put("3", Arrays.asList(new String[]{"d", "e", "f"}));
        map.put("4", Arrays.asList(new String[]{"g", "h", "i"}));
        map.put("5", Arrays.asList(new String[]{"j", "k", "l"}));
        map.put("6", Arrays.asList(new String[]{"m", "n", "o"}));
        map.put("7", Arrays.asList(new String[]{"p", "q", "r", "s"}));
        map.put("8", Arrays.asList(new String[]{"t", "u", "v"}));
        map.put("9", Arrays.asList(new String[]{"w", "x", "y", "z"}));

        List<String> results = getStringVariant("4155230", map);
        printList(results);
    }

    public static List<String> getStringVariant(String numbers, Map<String, List<String>> map){
        if(numbers.length() == 0) return Arrays.asList("");
        List<String> results = new ArrayList<String>();
        for(String letter : map.get(Character.toString(numbers.charAt(0)))){
            for(String subResult : getStringVariant(numbers.substring(1, numbers.length()), map)){
                results.add(letter + subResult);
            }
        }
        return results;
    }

    public static void printList(List<String> values) {
        String result = "";
        for(String value : values){
            result = result + "," + value;
        }
        result = result.substring(1, result.length());
        System.out.println(result);
    }

}
