学习笔记

# 1、字典树

    trie树，又称前缀树、单词查找树或键树。他是一个多叉树。  
    典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。  
    他的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

#### 基本性质

* 节点本身不存完整单词。
* 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
* 每个节点的所有子节点路径代表的字符都不相同。

#### 代码模板

```java
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
```

# 2、并查集

    常用于处理一些不交集的合并及查询问题

#### 代码模板

```java
public class UnionFind {
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    /**
     * 合并
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
}
```

# 3、AVL树和红黑树

    AVL树是一种自平衡二叉搜索树，也被称为高度平衡树。其任一节点对应的两颗子树的最大高度差为1。与其他二叉树相比，它的节点多记录了一个平衡因子，当平衡因子为1、0、-1时，被认为高度是平衡的，其他情况认为是不平衡的。  
    红黑树是一种近似平衡二叉搜索树，由鲁道夫·贝尔发明，他能确保任何一个节点的左右子树的高度差小于两倍。

#### 自平衡操作

* 左旋（右右子树）
* 右旋（左左子树）
* 左右旋（左右子树）
* 右左旋（右左子树）

#### 红黑树的特性

* 节点只有红色和黑色。
* 根节点是黑色。
* 每个叶子节点都是黑色的（NIL节点、空节点也是黑色的）。
* 不能有相邻两个连续的红色节点。
* 从任一节点到其每个叶子节点的所有路径都包含数量相同的黑色节点。