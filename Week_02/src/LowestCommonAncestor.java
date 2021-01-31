/**
 * 二叉树的最近公共祖先：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 如果该节点的子节点都不含有p和q，则其会返回null，
     * 如果含有其中一个节点，则会返回这个节点
     * 直到返回的节点不是p、q和null，则该节点为p和q的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            //如果root==p或者root==q说明肯定不是他们的公共祖先
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
