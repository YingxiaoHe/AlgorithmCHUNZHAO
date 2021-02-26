import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词接龙：https://leetcode-cn.com/problems/word-ladder/
 */
public class LadderLength1 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //为方便判断单词是否是在wordList中，将wordList放入Set中
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        //储存访问过的word
        Set<String> visited = new HashSet<>();
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        //双向BFS，左右交替扩散的步数之和为答案
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            //优先找小表进行扩散，遍历的情况少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            //开始扩散
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }
            //原来的beginVisited废弃，从nextLevelVisited开始新的双向BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }

    private boolean changeWordEveryOneLetter(String word, Set<String> endVisited, Set<String> visited,
                                             Set<String> wordSet, Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (originChar == c) {
                    continue;
                }
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }
}
