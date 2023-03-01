/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LC226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTreeRecursion(root);

        return root;
    }

    private void invertTreeRecursion(TreeNode node) {
        if (node.left == null && node.right == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) {
            invertTreeRecursion(node.left);
        }

        if (node.right != null) {
            invertTreeRecursion(node.right);
        }
    }
}