import java.util.ArrayList;
import java.util.Scanner;
public class Pangram
{

    public boolean isPangram (String str) throws IllegalArgumentException {
        if (str == null) throw new IllegalArgumentException("Napis nie moze byc nullem");
        if (str.equals("")) throw new IllegalArgumentException("Napis nie moze byc pusty");
        for (int i = 0; i < str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        return true;
    }

    public ArrayList<Boolean> isPangram(ArrayList<String> str)
    {
       ArrayList<Boolean> result = new ArrayList<Boolean>();
        for (String s : str) {
            result.add(isPangram(s));
        }
        return result;
    }
}