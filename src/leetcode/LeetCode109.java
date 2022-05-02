package leetcode;

public class LeetCode109 {

	/**
	 * 直接构造BST，中点用快慢指针寻找。
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		return recursion(head, null);

	}

	private TreeNode recursion(ListNode head, ListNode tail) {
		ListNode runner = head;
		ListNode walker = head;
		//这个return不能少
		if (head == tail) return null;
		//这while里的判断条件可以看成一个routine了，而且是!=tail，不是null
		while (runner.next != tail && runner.next.next != tail) {
			walker = walker.next;
			runner = runner.next.next;
		}
		TreeNode root = new TreeNode(walker.val);
		root.left = recursion(head, walker);
		root.right = recursion(walker.next, tail);

		return root;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
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
