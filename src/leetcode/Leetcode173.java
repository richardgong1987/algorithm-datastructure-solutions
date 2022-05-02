package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode173 {
	Deque<TreeNode> helper = new LinkedList<>();

	public Leetcode173(TreeNode root) {
		while (root != null) {
			helper.push(root);
			root = root.left;
		}
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return !helper.isEmpty();
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		TreeNode result = helper.pop();
		TreeNode node = result.right;
		while (node != null) {
			helper.push(node);
			node = node.left;
		}
		return result.val;
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
