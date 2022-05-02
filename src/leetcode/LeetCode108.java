package leetcode;

public class LeetCode108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return constructBST(nums, 0, nums.length - 1);
	}

	private TreeNode constructBST(int[] nums, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		if (lo == hi) {
			return new TreeNode(nums[lo]);
		}

		int mid = lo + (hi - lo) / 2;
		TreeNode root = new TreeNode(nums[mid]);

		root.left = constructBST(nums, lo, mid - 1);
		root.right = constructBST(nums, mid + 1, hi);

		return root;
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
