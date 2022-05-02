package leetcode;

public class LeetCode99 {
	TreeNode x;
	TreeNode y;
	TreeNode pred;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		x = null;
		y = null;
		pred = null;
		inorderSwap(root);
		// swap (assume x, y not null)
		int temp = x.val;
		x.val = y.val;
		y.val = temp;
	}

	private void inorderSwap(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderSwap(root.left);

		if (pred != null && pred.val > root.val) {
			y = root;
			if (x == null) {
				x = pred;
			} else {
				return;
			}
		}

		pred = root;

		inorderSwap(root.right);
	}

	public class TreeNode {
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

		@Override
		public String toString() {
			return val + "";
		}
	}

}
