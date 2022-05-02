package labuladong.graph;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeWithDepth {
	public static void printf(String format, Object... arg) {
		System.out.printf(format, arg);
	}

	// 输入一棵二叉树的根节点，遍历这棵二叉树所有节点
	void levelTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<State> q = new LinkedList<>();
		q.offer(new State(root, 1));

		// 遍历二叉树的每一个节点
		while (!q.isEmpty()) {
			State cur = q.poll();
			TreeNode cur_node = cur.node;
			int cur_depth = cur.depth;
			printf("节点 %s 在第 %s 层", cur_node, cur_depth);

			// 将子节点放入队列
			if (cur_node.left != null) {
				q.offer(new State(cur_node.left, cur_depth + 1));
			}
			if (cur_node.right != null) {
				q.offer(new State(cur_node.right, cur_depth + 1));
			}
		}
	}

	class State {
		// 记录 node 节点的深度
		int depth;
		TreeNode node;

		State(TreeNode node, int depth) {
			this.depth = depth;
			this.node = node;
		}
	}
}
