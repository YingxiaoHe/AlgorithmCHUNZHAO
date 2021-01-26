import java.util.*;

public class Preorder {

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

    List<Integer> preorderList = new ArrayList<>();

    /**
     * 递归
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return preorderList;
        }
        preorderList.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return preorderList;
    }

    /**
     * 迭代
     */
    public List<Integer> preorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : root.children) {
                stack.push(item);
            }
        }
        return output;
    }

}
