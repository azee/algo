package strings;

/**
 * Created by azee on 21.05.16.
 */
public class ValidateBrackets {

    public static void main(String... args){
        System.out.println(validate("abra(aadabra)s"));
        System.out.println(validate("abra(aad(ab)ra)s"));
        System.out.println(validate("abra(aadab)ra)s"));
        System.out.println(validate("abra(aad(abra)s"));
        System.out.println(validate("abra(aad(ab)ras"));
    }

    public static boolean validate(String str){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ')'){
                return false;
            }
            if (str.charAt(i) == '('){
                if (str.lastIndexOf(')') < i){
                    return false;
                } else {
                    return validate(str.substring(i + 1, str.lastIndexOf(')') - 1));
                }

            }
        }
        return true;
    }
}
