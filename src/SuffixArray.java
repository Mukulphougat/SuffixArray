import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SuffixArray {
    public String[] text;
    public int length;
    public int[] index;
    public String[] suffix;
    public List<String> ls = new ArrayList<>();
    public SuffixArray(String text)
    {
        this.text = new String[text.length()];

        for (int i = 0; i < text.length(); i++)
        {
            this.text[i] = text.substring(i, i+1);
        }

        this.length = text.length();
        this.index = new int[length];
        for (int i = 0; i < length; i++)
        {
            index[i] = i;
        }

        suffix = new String[length];
    }
    public void createSuffixArray()
    {
        for(int index = 0; index < length; index++)
        {
            String text = "";
            for (int text_index = index; text_index < length; text_index++)
            {
                text += this.text[text_index];
            }
            suffix[index] = text;
        }

        int back;
        for (int iteration = 1; iteration < length; iteration++)
        {
            String key = suffix[iteration];
            int keyindex = index[iteration];

            for (back = iteration - 1; back >= 0; back--)
            {
                /*
                suffix[back].compareTo(key)
                return 0 if both strings are same
                return greater than 0 if suffix[back] greater than String key
                return smaller than 0 if suffix[back] smaller than string key
                 */
                if (suffix[back].compareTo(key) > 0)
                {
                    suffix[back + 1] = suffix[back];
                    index[back + 1] = index[back];
                }
                else
                {
                    break;
                }
            }
            suffix[ back + 1 ] = key;
            index[back + 1 ] = keyindex;
        }


        /*
        System.out.println("SUFFIX \t INDEX");
        for ( int i = 0 ; i < suffix.length ; i++ ) {
            System.out.println(suffix[i]+" "+index[i]);
        }

         */


    }
}
