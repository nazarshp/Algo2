

public class Main
{

    public static void main(String[] args)
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";


        KMP(txt, pat);
    }




    public static int KMP(String string, String subString)
    {

        if (subString == null || subString.length() == 0)
        {
            System.out.println("Found pattern at index 0");
            return 0;
        }


        if (string == null || subString.length() > string.length())
        {
            System.out.println("Pattern not found");
            return -1;
        }

        char[] chars = subString.toCharArray();


        int[] next = new int[subString.length() + 1];
        for (int i = 1; i < subString.length(); i++)
        {
            int j = next[i + 1];

            while (j > 0 && chars[j] != chars[i]) {
                j = next[j];
            }

            if (j > 0 || chars[j] == chars[i]) {
                next[i + 1] = j + 1;
            }
        }

        for (int i = 0, j = 0; i < string.length(); i++)
        {
            if (j < subString.length() && string.charAt(i) == subString.charAt(j))
            {
                if (++j == subString.length()) {
                    System.out.println("Found pattern at index " + (i - j + 1));
                    return (i - j + 1);
                }
            }
            else if (j > 0)
            {
                j = next[j];
                i--;
            }
        }
        return -1;
    }
}