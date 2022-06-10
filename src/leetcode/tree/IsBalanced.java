package leetcode.tree;

public class IsBalanced {
    public static void main(String[] args) {
        IsBalanced isBalanced = new IsBalanced();
        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(3);

        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(4);

        boolean balanced = isBalanced.isBalanced(treeNode);
    }

    public boolean isBalanced(TreeNode root) {
        int helper = helper(root, 0);
        return helper >= 0;
    }

    private int helper(TreeNode root, int height) {
        if (root == null) {
            return height;
        }
        int leftH = helper(root.left, height + 1);
        int rightH = helper(root.right, height + 1);
        if (leftH < 0 || rightH < 0 || Math.abs(leftH - rightH) > 1) {
            System.out.println(leftH + ":" + rightH);
            return -1;
        }
        int max = Math.max(leftH, rightH);
        System.out.println(leftH + "------" + rightH + ", max:" + max);
        return max;
    }
}
