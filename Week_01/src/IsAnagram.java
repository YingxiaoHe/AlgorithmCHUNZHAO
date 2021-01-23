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
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            letter[t.charAt(i) - 'a']--;
            if (letter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
