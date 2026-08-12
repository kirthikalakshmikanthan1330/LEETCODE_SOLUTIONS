import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return mirror(root.left, root.right);
    }
    boolean mirror(TreeNode left, TreeNode right) {
        // Both are null
        if (left == null && right == null) {
            return true;
        }
        // Only one is null
        if (left == null || right == null) {
            return false;
        }
        // Values are different
        if (left.val != right.val) {
            return false;
        }
        // Check mirror positions
        return mirror(left.left, right.right)
            && mirror(left.right, right.left);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Example:
        // Enter number of nodes
        int n = sc.nextInt();
        /*
         * For practicing tree problems, constructing a tree from
         * level-order input requires handling "null" values.
         * So here we use a simple level-order representation.
         */
        if (n == 0) {
            System.out.println(true);
            return;
        }
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        // Create nodes
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(values[i]);
        }
        // Connect nodes as a complete binary tree
        for (int i = 0; i < n; i++) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            if (leftIndex < n) {
                nodes[i].left = nodes[leftIndex];
            }
            if (rightIndex < n) {
                nodes[i].right = nodes[rightIndex];
            }
        }
        TreeNode root = nodes[0];
        Solution s = new Solution();
        System.out.println(s.isSymmetric(root));
    }
}