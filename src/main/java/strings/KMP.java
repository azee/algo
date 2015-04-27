package strings;

/**
 * Created by azee on 14.01.15.
 */
public class KMP {
    private static int[] failure;

    public static int find(String haystack, String needle) {
        /** pre construct failure array for a pattern **/
        failure = new int[needle.length()];
        prefix(needle);
        return posMatch(haystack, needle);
    }

    /** Failure function for a pattern **/
    private static void prefix(String needle)
    {
        int n = needle.length();
        failure[0] = -1;
        for (int j = 1; j < n; j++)
        {
            int i = failure[j - 1];
            while ((needle.charAt(j) != needle.charAt(i + 1)) && i >= 0)
                i = failure[i];
            if (needle.charAt(j) == needle.charAt(i + 1))
                failure[j] = i + 1;
            else
                failure[j] = -1;
        }
    }

    /** Function to find match for a pattern **/
    private static int posMatch(String haystack, String needle)
    {
        int i = 0, j = 0;
        int lens = haystack.length();
        int lenp = needle.length();
        while (i < lens && j < lenp)
        {
            if (haystack.charAt(i) == needle.charAt(j))
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
