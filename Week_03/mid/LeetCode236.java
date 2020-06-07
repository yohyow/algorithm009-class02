import javax.swing.tree.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LeetCode236 {

    TreeNode mTreeNode;
    /**
     * 递归遍历整个二叉树
     */
    private boolean recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean rson = recursion(root.right, p, q);
        boolean lson = recursion(root.left, p, q);
        if (((root.val == p.val || root.val == q.val) && (rson || lson)) || (rson && lson)) {
            mTreeNode = root;
        } 
        return (root.val == p.val || root.val == q.val) || rson || lson;
    }
}