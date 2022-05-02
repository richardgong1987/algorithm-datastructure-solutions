package programmerxiaohui.chapter3.part2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by weimengshu on 2018/9/22.
 */
public class BinaryTreeTraversalStack {

	/**
	 * 构建二叉树
	 *
	 * @param inputList 输入序列
	 */
	public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
		TreeNode node = null;
		if (inputList == null || inputList.isEmpty()) {
			return null;
		}
		Integer data = inputList.removeFirst();
		//这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；如果元素非空，继续递归构建该节点的左右孩子。
		if (data != null) {
			node = new TreeNode(data);
			node.leftChild = createBinaryTree(inputList);
			node.rightChild = createBinaryTree(inputList);
		}
		return node;
	}

	/**
	 * 二叉树非递归前序遍历
	 *
	 * @param root 二叉树根节点
	 */
	public static void preOrderTraveralWithStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode treeNode = root;
		while (treeNode != null || !stack.isEmpty()) {
			//迭代访问节点的左孩子，并入栈
			while (treeNode != null) {
				System.out.println(treeNode.data);
				stack.push(treeNode);
				treeNode = treeNode.leftChild;
			}
			//如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
			if (!stack.isEmpty()) {
				treeNode = stack.pop();
				treeNode = treeNode.rightChild;
			}
		}
	}

	/**
	 * 二叉树非递归中序遍历
	 *
	 * @param root 二叉树根节点
	 */
	public static void inOrderTraveralWithStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode treeNode = root;
		while (treeNode != null || !stack.isEmpty()) {
			while (treeNode != null) {
				stack.push(treeNode);
				treeNode = treeNode.leftChild;
			}
			if (!stack.isEmpty()) {
				treeNode = stack.pop();
				System.out.println(treeNode.data);
				treeNode = treeNode.rightChild;
			}
		}
	}

	public static void postOrderTraveralWithStack(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		TreeNode treeNode = root;
		stack1.push(treeNode);
		while (!stack1.isEmpty()) {
			TreeNode temp = stack1.pop();
			stack2.push(temp);
			if (temp.leftChild != null) {
				stack1.push(temp.leftChild);
			}
			if (temp.rightChild != null) {
				stack1.push(temp.rightChild);
			}
		}
		while (!stack2.isEmpty()) {
			TreeNode temp = stack2.pop();
			System.out.println(temp.data);
		}

	}

	public static void main(String[] args) {
		LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
		TreeNode treeNode = createBinaryTree(inputList);
		System.out.println("前序遍历：");
		preOrderTraveralWithStack(treeNode);
		System.out.println("中序遍历：");
		inOrderTraveralWithStack(treeNode);
		System.out.println("后序遍历：");
		postOrderTraveralWithStack(treeNode);
	}

	/**
	 * 二叉树节点
	 */
	private static class TreeNode {
		int data;
		TreeNode leftChild;
		TreeNode rightChild;

		TreeNode(int data) {
			this.data = data;
		}
	}

}
