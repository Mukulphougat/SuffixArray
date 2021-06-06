import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args){
        String string = "attcatg";
        SuffixArray suffixArray = new SuffixArray(string);
        for ( String i : suffixArray.text ) System.out.print(i+" ");
        System.out.println();
        for ( int i : suffixArray.index ) System.out.print(i+" ");
        System.out.println();
        suffixArray.createSuffixArray();

    }
}
