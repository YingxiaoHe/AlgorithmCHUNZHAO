/**
 * Trie树模板
 */
public class Trie {

    private boolean isEnd;

    private Trie[] next;

    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    /**
     * 插入一个单词到Trie树中
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie node = this;
        char[] words = word.toCharArray();
        for (char ch : words) {
            int index = ch - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Trie();
            }
            node = node.next[index];
        }
        node.isEnd = true;
    }

    /**
     * 查找该字典是否在树中
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * 查找树中是否包含有该前缀
     *
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    /**
     * 找到word中最后一个字母所在的节点并返回
     *
     * @param word
     * @return 最后一个字母所在的节点
     */
    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (char ch : words) {
            int index = ch - 'a';
            node = node.next[index];
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
