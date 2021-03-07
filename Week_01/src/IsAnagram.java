import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    /**
     * 排序
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.equals(charS, charT);
    }

    /**
     * hashmap
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letter = new int[24];
        for (char cs : s.toCharArray()) {
            letter[cs - 'a']++;
        }
        for (char ct : t.toCharArray()) {
            letter[ct - 'a']--;
            if (letter[ct - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
