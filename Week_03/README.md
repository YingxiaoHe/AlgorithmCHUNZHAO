学习笔记

# 1、分治与回溯
    分治与回溯都是递归的一种，他们的本质是寻找重复性。最优重复性就是动态规划，而最近重复性根据实际问题可以选择分治或者回溯。而寻找重复性就是寻找子问题，将一个大问题分解成多个相似的子问题。
### 一般递归的代码逻辑：
1、结束递归的条件  
2、处理当层业务逻辑  
3、进入下一层递归  
4、返回当层结果  
### 分治的代码逻辑：
1、结束递归的条件  
2、处理当层业务逻辑  
3、进入下一层递归  
4、将下一层递归返回的子结果进行合并  
5、返回合并后的结果  
### 回溯的代码逻辑：
1、结束递归的条件  
2、处理当层逻辑  
3、进入下一层递归  
4、还原现场  
# 2、深度优先搜索（DFS）与广度优先搜索（BFS）  
深度优先搜索：尽可能深的搜索树的分支。  
广度优先搜索：一层一层的搜索树的每一个节点。  
### 深度优先搜索代码模板：
递归：
```java
public class Template {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        dfs(root, 0, results);
        return results;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> results) {
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if (root.chirdren != null) {
            for (TreeNode node : root.chirdren) {
                dfs(node, level + 1, results);
            }
        }
    }
}
```
迭代：
```java
public class Template {
    public List<Integer> dfs(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return results;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            ThreeNode node = stach.pop();
            results.add(node.val);
            for (ThreeNode item : node.children) {
                stack.push(item);
            }
        }
        return results;
    }
}
```
### 广度优先遍历代码模板：
```java
public class Template {
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                list.add(node.val);
                if (node.chridren != null) {
                    node.chridren.foreach(n -> nodes.add(n));
                }
            }
            results.addAll(list);
        }
        return results;
    }
}
```
# 3、贪心算法
    贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。  
    贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。  
    贪心算法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。  
    一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于谈心算法的高效性以及所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精准的问题。
# 4、二分查找  
### 二分查找的前提：  
    1、目标函数单调性（单调递增或单调递减）  
    2、存在上下边界  
    3、能够通过索引访问（即随机访问）  
### 代码模板：
```java
public class Template {
    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
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