package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by azee on 20.09.17.
 */
public class StringWildcardsSubstitutions {

    public static void main(String[] args) {
        System.out.println(getValues("0?1"));
        System.out.println(getValues("0?1?1"));
        System.out.println(getValues("0?"));
        System.out.println(getValues("?0"));
        System.out.println(getValues("011"));
        System.out.println(getValues(""));
    }

    public static Set<String> getValues(String str){
        Set<String> result = new HashSet<>();
        if (str.length() == 0){
            result.add("");
            return result;
        }
        if (str.length() == 1){
            result.add(str);
            return result;
        }
        int index = 0;
        while (index < str.length() && '?' != str.charAt(index)){
            index++;
        }
        if (index == str.length()){
            result.add(str);
            return result;
        }

        String tail = str.substring(index + 1, str.length());
        String head = str.substring(0, index);
        for (String tailEntry : getValues(tail)){
            result.add(head + "0" +  tailEntry);
            result.add(head + "1" + tailEntry);
        }
        return result;
    }
}
