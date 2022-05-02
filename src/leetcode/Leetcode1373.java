package leetcode;

public class Leetcode1373 {
	// 全局变量，记录 BST 最大节点之和
	int maxSum = 0;

	public int maxSumBST(TreeNode root) {
		traverse(root);
		return maxSum;
	}

	int[] traverse(TreeNode root) {
		// base case
		if (root == null) {
			return new int[]{
					1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
			};
		}
		// 递归计算左右子树
		int[] left = traverse(root.left);
		int[] right = traverse(root.right);

		/******* 后序遍历位置 *******/
		int[] res = new int[4];
		// 这个 if 在判断以 root 为根的二叉树是不是 BST
		if (left[0] == 1 && right[0] == 1 &&
				root.val > left[2] && root.val < right[1]) {
			// 以 root 为根的二叉树是 BST
			res[0] = 1;
			// 计算以 root 为根的这棵 BST 的最小值
			res[1] = Math.min(left[1], root.val);
			// 计算以 root 为根的这棵 BST 的最大值
			res[2] = Math.max(right[2], root.val);
			// 计算以 root 为根的这棵 BST 所有节点之和
			res[3] = left[3] + right[3] + root.val;
			// 更新全局变量
			maxSum = Math.max(maxSum, res[3]);
		} else {
			// 以 root 为根的二叉树不是 BST
			res[0] = 0;
			// 其他的值都没必要计算了，因为用不到
		}
		/**************************/

		return res;
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
