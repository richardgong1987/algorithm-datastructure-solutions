package util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Utils {
	static String SEP = ",";
	static String NULL = "null";

	// for debug
	private static void print(int cnt, String str) {
		System.out.println(" ".repeat(cnt) + str);
	}

	/* 将字符串反序列化为二叉树结构 */
	public static TreeNode deserialize(String data) {
		if (data.isEmpty()) return null;
		String[] nodes = data.split(SEP);
		// 第一个元素就是 root 的值
		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

		// 队列 q 记录父节点，将 root 加入队列
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		for (int i = 1; i < nodes.length; ) {
			// 队列中存的都是父节点
			TreeNode parent = q.poll();
			// 父节点对应的左侧子节点的值
			String left = nodes[i++];
			if (!left.equals(NULL)) {
				parent.left = new TreeNode(Integer.parseInt(left));
				q.offer(parent.left);
			} else {
				parent.left = null;
			}
			// 父节点对应的右侧子节点的值
			String right = nodes[i++];
			if (!right.equals(NULL)) {
				parent.right = new TreeNode(Integer.parseInt(right));
				q.offer(parent.right);
			} else {
				parent.right = null;
			}
		}
		return root;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void printArray(int[][] dbs) {
		for (int[] db : dbs) {
			System.out.println(Arrays.toString(db));
		}
	}

	public static void printf(String format, Object... arg) {
		System.out.printf(format, arg);
	}
}
