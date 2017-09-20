package strings;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/17/13
 * Time: 1:35 PM
  */
public class VariateDict {

    public static void main(String ...args){
        List<String> permutations = getPermutations("автомобиль", dictionaryProvider());
        System.out.println(permutations.size());
    }

    public static List<String> getPermutations(String inputString, Map<Integer, List<String>> dictionary){
        List<String> output = new ArrayList<String>();

        if(inputString.length() == 1){
            for(String substitutions : dictionary.get((int) inputString.charAt(0))){
                output.add(substitutions);
            }
            return output;
        }

        for(String variant : getPermutations(inputString.substring(1), dictionary)){
            output.add(inputString.charAt(0) + variant);

            List<String> substitutions = dictionary.get((int) inputString.charAt(0));
            if(substitutions != null){
                for(String substitution : substitutions){
                    output.add(substitution + variant);
                }
            } else {
                System.out.println("Can't find permutation for: [" + inputString.charAt(0) + "].");
            }
        }
        return output;
    }


    public static Map<Integer, List<String>> dictionaryProvider(){
        Map<Integer, List<String>> dictionary = new HashMap<Integer, List<String>>();
        dictionary.put((int) "а".charAt(0), Arrays.asList("А", "a", "A", "4"));
        dictionary.put((int) "б".charAt(0), Arrays.asList("Б", "B", "b", "6"));
        dictionary.put((int) "в".charAt(0), Arrays.asList("Б", "B", "b", "6"));
        dictionary.put((int) "г".charAt(0), Arrays.asList("Г", "G", "g"));
        dictionary.put((int) "д".charAt(0), Arrays.asList("Д", "D", "d"));
        dictionary.put((int) "е".charAt(0), Arrays.asList("Е", "e", "E", "3"));
        dictionary.put((int) "ё".charAt(0), Arrays.asList("е", "Е", "Е", "e", "E", "3"));
        dictionary.put((int) "ж".charAt(0), Arrays.asList("Ж", "G", "g"));
        dictionary.put((int) "з".charAt(0), Arrays.asList("З", "3", "z"));
        dictionary.put((int) "и".charAt(0), Arrays.asList("И", "N"));
        dictionary.put((int) "к".charAt(0), Arrays.asList("К", "k", "K"));
        dictionary.put((int) "л".charAt(0), Arrays.asList("Л", "П", "п"));
        dictionary.put((int) "м".charAt(0), Arrays.asList("М", "m", "M"));
        dictionary.put((int) "н".charAt(0), Arrays.asList("Н", "H", "h"));
        dictionary.put((int) "о".charAt(0), Arrays.asList("О", "O", "o", "0"));
        dictionary.put((int) "п".charAt(0), Arrays.asList("П", "n"));
        dictionary.put((int) "р".charAt(0), Arrays.asList("Р", "p", "P"));
        dictionary.put((int) "с".charAt(0), Arrays.asList("С", "C", "c"));
        dictionary.put((int) "т".charAt(0), Arrays.asList("Т", "T", "t"));
        dictionary.put((int) "у".charAt(0), Arrays.asList("У", "Y", "y"));
        dictionary.put((int) "ф".charAt(0), Arrays.asList("Ф"));
        dictionary.put((int) "х".charAt(0), Arrays.asList("Х", "x", "X"));
        dictionary.put((int) "ц".charAt(0), Arrays.asList("Ц"));
        dictionary.put((int) "ч".charAt(0), Arrays.asList("Ч", "4"));
        dictionary.put((int) "ш".charAt(0), Arrays.asList("Ш", "щ", "Щ"));
        dictionary.put((int) "щ".charAt(0), Arrays.asList("Щ", "ш", "Ш"));
        dictionary.put((int) "ъ".charAt(0), Arrays.asList("Ъ", "ь", "Ь", "b"));
        dictionary.put((int) "Ы".charAt(0), Arrays.asList("ы", "61", "Ь1"));
        dictionary.put((int) "ь".charAt(0), Arrays.asList("Ь", "Ъ", "ъ", "b"));
        dictionary.put((int) "э".charAt(0), Arrays.asList("Э", "з"));
        dictionary.put((int) "ю".charAt(0), Arrays.asList("Ю", "1ь", "1ъ", "lь", "lъ", "10", "10", "l0", "l0", "1-0", "1-0", "l-0", "l-0"));
        dictionary.put((int) "я".charAt(0), Arrays.asList("Я", "R", "r"));
        return dictionary;
    }
}
