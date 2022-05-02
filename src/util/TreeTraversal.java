package util;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTraversal {

	/**
	 * 前序遍历,非递归实现.  根-左-右
	 */
	public static void preOrder(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				System.out.println(root.val);
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			}
		}
	}

	/**
	 * 中序遍历,非递归实现. 左-根-右
	 */
	public static void inOrder(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				System.out.println(root.val);
				root = root.right;
			}
		}
	}

	/**
	 * 后序遍历,非递归实现  左-右-根
	 */
	public static void postOrder(TreeNode root) {
		int left = 1;//在辅助栈里表示左节点
		int right = 2;//在辅助栈里表示右节点
		Deque<TreeNode> stack = new LinkedList<>();
		Deque<Integer> stack2 = new LinkedList<>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

		while (root != null || !stack.isEmpty()) {
			while (root != null) {//将节点压入栈1，并在栈2将节点标记为左节点
				stack.push(root);
				stack2.push(left);
				root = root.left;
			}

			while (!stack.isEmpty() && stack2.peek() == right) {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
				stack2.pop();
				System.out.println(stack.pop().val);
			}

			if (!stack.isEmpty() && stack2.peek() == left) {//如果是从左子节点返回父节点，则将标记改为右子节点
				stack2.pop();
				stack2.push(right);
				root = stack.peek().right;
			}

		}
	}

	/**
	 * 层次遍历
	 */
	public static void levelOrder(TreeNode root) {
		if (root == null)
			return;

		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		TreeNode current;

		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(current.val);
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}
}
