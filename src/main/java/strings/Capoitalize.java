package strings;

/**
 * Created by azee on 26.01.15.
 */
public class Capoitalize {

    public static void main(String... args){
        System.out.println(capitalize("Maaamma mIa!"));
    }

    public static String capitalize(String input){
        StringBuffer sb = new StringBuffer();
        for (Character character : input.toCharArray()){
            sb.append(Character.toUpperCase(character));
        }
        return sb.toString();
    }
}
