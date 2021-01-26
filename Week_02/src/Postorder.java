import java.util.*;

public class Postorder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    List<Integer> recursionList = new ArrayList<>();

    /**
     * 递归
     */
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return recursionList;
        }

        for (Node child : root.children) {
            postorder(child);
        }

        recursionList.add(root.val);
        return recursionList;
    }

    /**
     * 迭代
     **/
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            stack.addAll(root.children);
        }
        Collections.reverse(list);
        return list;
    }
}
