package leetcode;

public class Leetcode235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else {
				return root;
			}

		}
		return null;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}


}
