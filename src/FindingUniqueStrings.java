import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindingUniqueStrings {
    /*
    public static List<String> ls = new ArrayList<>();
    public static HashSet<String> hs = new HashSet<>();
    static void subString(char str[], int n) {

        for (int len = 1; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {
                StringBuilder sb = new StringBuilder();
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    sb.append(str[k]);
                }
                if ( hs.contains(sb.toString()) == false ) hs.add(sb.toString());
                ls.add(sb.toString());
            }
        }
    }

     */
    public static int[] lcp;
    public static int LCP_SUM(String given){
        lcp = new int[given.length()];
        SuffixArray suffixArray = new SuffixArray(given);
        suffixArray.createSuffixArray();

        lcp[0] = 0;
        for ( int i = 0 ; i < suffixArray.suffix.length ; i++ ) {
            if( i == suffixArray.suffix.length - 1 ) break;
            String a = suffixArray.suffix[i];
            String b = suffixArray.suffix[i+1];
            int f = 0, s = 0;
            int len = 0;
            while ( f < a.length() && s < b.length() && a.charAt(f) == b.charAt(s) ) {
                f++;
                s++;
                len++;
            }
            lcp[i] = len;
        }
        int ans = 0;
        for ( int i = 0 ; i < lcp.length ; i++ ) {
            ans += lcp[i];
        }
        return ans;
    }
    public static void main(String[] args){
        String given = "ABC";
        int lcps = LCP_SUM(given);
        int n = given.length();
        int numOfSubstring = n * ( n + 1 ) / 2;
        int res = numOfSubstring-lcps;
        System.out.println(numOfSubstring+" "+res);


    }
}
