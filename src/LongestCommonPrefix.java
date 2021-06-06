public class LongestCommonPrefix {
    public static int LCP(String given){
        int[] lcp = new int[given.length()];
        SuffixArray suffixArray = new SuffixArray(given);
        suffixArray.createSuffixArray();
        lcp[0] = 0;
        for ( int i = 1 ; i < suffixArray.suffix.length ; i++ ) {
            if( i == suffixArray.suffix.length - 1 ) break;
            String a = suffixArray.suffix[i];
            String b = suffixArray.suffix[i+1];
            int f = 0, s = 0;
            int len = 0;
            while ( f < a.length() && s < b.length() && a.charAt(f++) == b.charAt(s++) ) {
                len++;
            }
            lcp[i] = len;
        }
        int ans = Integer.MIN_VALUE;
        for ( int i : lcp ) {
            ans = Math.max(i,ans);
        }
        return ans;
    }
    public static void main(String[] args){
        String given = "AZAZA";
        int ans = LCP(given);
        System.out.println(ans);
    }
}
