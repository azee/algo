package strings;

public class Palindromes {

    public static void main(String... args){
        String val = "abbababba";
        System.out.println(countPalindromes(val));
    }

    static long countPalindromes(String val){
        return getAllVariations(val).stream().filter(Main::isPalindrome).count();
    }

    static Set<String> getAllVariations(String val){
        Set<String> result = new HashSet<>();
        for (int i = 0; i < val.length(); i++){
            for (int j = i + 1; j <= val.length(); j++){
                result.add(val.substring(i, j));
            }
        }
        return result;
    }

    static boolean isPalindrome(String val){
        if (val.length() <= 1){
            return false;
        }
        for (int i = 0; i < val.length()/2; i++){
            if (val.charAt(i) != val.charAt(val.length() - i - 1)){
                return false;
            }
        }
        System.out.println(val);
        return true;
    }
}
