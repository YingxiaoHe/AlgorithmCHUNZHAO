/**
 * 917. 仅仅反转字母：https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {

    /**
     * 双指针
     * 时间复杂度：O(n / 2)
     * 空间复杂度：O(1)
     */
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            if (!Character.isLetter(charArray[left])) {
                left++;
            } else if (!Character.isLetter(charArray[right])) {
                right--;
            } else {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        reverseOnlyLetters.reverseOnlyLetters("ab-cd");
    }
}
