/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class LC111MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node.left != null && node.right != null) {
            return Math.min(dfs(node.left), dfs(node.right)) + 1;
        } else if (node.left != null) {
            return dfs(node.left) + 1;
        } else if (node.right != null) {
            return dfs(node.right) + 1;
        } else {
            return 1;
        }
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// class Solution {
//     public int minDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         if (root.left == null && root.right == null) {
//             return 1;
//         }

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         int depth = 1;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = queue.poll();

//                 if (cur.left == null && cur.right == null) {
//                     return depth;
//                 }

//                 if (cur.left != null) {
//                     queue.offer(cur.left);
//                 }

//                 if (cur.right != null) {
//                     queue.offer(cur.right);
//                 }
//             }

//             depth++;
//         }
//         // This line of code never gets the chance to get executed.
//         return depth;
//     }
// }