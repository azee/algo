package strings;

/**
 * Created by azee on 14.01.15.
 */
public class KMP {
    private static int[] failure;

    public static int find(String text, String toFind) {
        /** pre construct failure array for a pattern **/
        failure = new int[toFind.length()];
        fail(toFind);
        return posMatch(text, toFind);
    }

    /** Failure function for a pattern **/
    private static void fail(String pattern)
    {
        int n = pattern.length();
        failure[0] = -1;
        for (int j = 1; j < n; j++)
        {
            int i = failure[j - 1];
            while ((pattern.charAt(j) != pattern.charAt(i + 1)) && i >= 0)
                i = failure[i];
            if (pattern.charAt(j) == pattern.charAt(i + 1))
                failure[j] = i + 1;
            else
                failure[j] = -1;
        }
    }

    /** Function to find match for a pattern **/
    private static int posMatch(String text, String pattern)
    {
        int i = 0, j = 0;
        int lens = text.length();
        int lenp = pattern.length();
        while (i < lens && j < lenp)
        {
            if (text.charAt(i) == pattern.charAt(j))
            {
                i++;
                j++;
            }
            else if (j == 0)
                i++;
            else
                j = failure[j - 1] + 1;
        }
        return ((j == lenp) ? (i - lenp) : -1);
    }
}
