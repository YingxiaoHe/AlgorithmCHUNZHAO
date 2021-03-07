import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串：https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class IsIsomorphic {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1) s+t
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if ((s2t.containsKey(chs) && s2t.get(chs) != cht) || (t2s.containsKey(cht) && t2s.get(cht) != chs)) {
                return false;
            }
            s2t.put(chs, cht);
            t2s.put(cht, chs);
        }
        return true;
    }
}
