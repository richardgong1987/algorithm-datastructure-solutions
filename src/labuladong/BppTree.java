package labuladong;

import util.Bplusplus;
import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BppTree {
	// 输入一棵多叉树的根节点，层序遍历这棵多叉树
	public static Bplusplus levelTraverse(Bplusplus root) {
		if (root == null) {
			return null;
		}
		Queue<Bplusplus> queue = new LinkedList<>();
		int depth = 1;
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Bplusplus current = queue.poll();
				System.out.println(current.getVal());
				for (Bplusplus child : current.getChildren()) {
					queue.offer(child);
				}

			}
			depth++;
		}
		System.out.println(depth);
		return root;
	}

	class State {
		int depth;
		TreeNode node;

		public State(TreeNode node, int depth) {
			this.depth = depth;
			this.node = node;
		}
	}

	void levelTraverseBinaryTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<State> queue = new LinkedList<>();
		queue.offer(new State(root, 1));

		while (!queue.isEmpty()) {
			State current = queue.poll();
			TreeNode currentNode = current.node;

			System.out.printf("%s在第%s层", currentNode.val, current.depth);

			if (currentNode.left != null) {
				queue.offer(new State(currentNode.left, current.depth + 1));
			}
			if (currentNode.right != null) {
				queue.offer(new State(currentNode.right, current.depth + 1));
			}
		}
	}
}
