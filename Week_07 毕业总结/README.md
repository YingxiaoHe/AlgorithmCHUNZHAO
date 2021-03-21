学习笔记


# 模板汇总
### 递归
```java
public class Template {
    public void recursion(int level, String... str) {
        //递归终止条件
        if (level > MAX_LEVEL) {
            return;
        }
        //当前层逻辑
        process(level, str);
        //进入下一层递归
        recursion(level + 1, str);
        //清理当前逻辑
    }
}
```
### DFS
```java
//递归
public class Template {
    public List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.children != null) {
            for (TreeNode child : root.children) {
                dfs(chird, level + 1, result);
            }
        }
    }
}
//迭代
public class Template {
    public List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            for (TreeNode child : node.children) {
                stack.push(chird);
            }
        }
        return result;
    }
}
```
### BFS
```java
public class Template {
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.chridren != null) {
                    node.chridren.foreach(chrid -> queue.add(chrid));
                }
            }
            result.addAll(list);
        }
        return result;
    }
}
```
### 二分查找
```java
public class Template {
    public int binarySearch(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return array[mid];
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```
### 字典树
```java
public class Template {
    public class Trie {
        private boolean isEnd;
        private Trie[] next;

        public Trie () {
            isEnd = false;
            next = new Trie[26];
        }

        /**
         * 插入一个单词到Trie树中
         *
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            char[] words = word.toCharArray();
            Trie node = this;
            for (char ch : words) {
                int index = ch - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new Trie();
                }
                node = node.next[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        public Trie searchPrefix(String word) {
            if (word == null || word.length() == 0) {
                return null;
            }
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
}
```
### 快速排序
```java
public class Template {
    public int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int begin, int end) {
        if (end < begin) {
            return;
        }
        int poivt = partition(array, begin, end);
        quickSort(array, begin, poivt - 1);
        quickSort(array, poivt + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        int count = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]) {
                int temp = array[i];
                array[i] = array[count];
                array[count] = temp;
                count++;
            }
        }
        int temp = array[count];
        array[acount] = array[end];
        array[end] = temp;
        return count;
    }
}
```
### 归并排序
```java
public class Template {
    public int[] mergeSort(int[] array) {
        mergeSort(array, 0 , array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
```


### 化繁为简的思想
    1、避免人肉递归
    2、找到最近最简方法，将其拆解成可重复解决的问题
    3、数学归纳法思维，寻找重复性
### 学习要点
    1、过遍数
    2、刻意练习——练习缺陷、弱点的地方
    3、防止只做一遍
    4、五毒神掌
### 经典习题
    爬楼梯、硬币兑换
    括号匹配、括号生成、直方图最大面积、滑动窗口
    二叉树遍历、分层输出树、判断二叉排序树
    股票买卖、偷房子、字符串编辑距离、最长上升子序列、最长公共子序列
    异位词（判断和归类）、回文数（最大回文串）、regex和通配符匹配
    高级数据结构（Trie、BloomFilter、LRU Cache等）