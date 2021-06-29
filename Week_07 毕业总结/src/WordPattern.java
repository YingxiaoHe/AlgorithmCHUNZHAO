import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律：https://leetcode-cn.com/problems/word-pattern/
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> ch2StrMap = new HashMap<>();
        Map<String, Character> str2ChMap = new HashMap<>();
        String[] strings = s.split(" ");
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String str = strings[i];
            char ch = chars[i];
            if (ch2StrMap.get(ch) == null) {
                ch2StrMap.put(ch, str);
                str2ChMap.put(str, ch);
            } else if (!ch2StrMap.get(ch).equals(str) ||
                    str2ChMap.get(str) != ch) {
                return false;
            }
        }
        return true;
    }

}
