package leetcode;

import util.TreeNode;

public class Leetcode337 {

	private final int MAX_CURRENT_SUB_TREE = 0;
	private final int MAX_LEFT_RIGHT_CHILD = 1;
	private final int NOT_ROB = 0;
	private final int ROB = 1;

	public int rob(TreeNode root) {
		return robResult(root)[MAX_CURRENT_SUB_TREE];
	}

	private int[] robResult(TreeNode root) {
		/**
		 * first element:  max of rob current sub tree
		 * second element: max of rob left child and right child
		 */
		int[] res = {0, 0};

		if (root == null) return res;

		int[] left = robResult(root.left);
		int[] right = robResult(root.right);

		res[MAX_LEFT_RIGHT_CHILD] = left[MAX_CURRENT_SUB_TREE] + right[MAX_CURRENT_SUB_TREE];
		res[MAX_CURRENT_SUB_TREE] = Math.max(res[MAX_LEFT_RIGHT_CHILD], left[MAX_LEFT_RIGHT_CHILD] + right[MAX_LEFT_RIGHT_CHILD] + root.val);

		return res;
	}

	public int rob2(TreeNode root) {
		int[] result = robInternal(root);
		return Math.max(result[NOT_ROB], result[ROB]);
	}

	private int[] robInternal(TreeNode root) {
		int[] res = new int[2];
		if (root == null) return res;

		int[] left = robInternal(root.left);
		int[] right = robInternal(root.right);

		res[NOT_ROB] = Math.max(left[NOT_ROB], left[ROB]) + Math.max(right[NOT_ROB], right[ROB]);
		res[ROB] = left[NOT_ROB] + right[NOT_ROB] + root.val;

		return res;
	}
}
