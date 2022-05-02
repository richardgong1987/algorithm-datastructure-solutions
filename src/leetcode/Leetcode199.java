package leetcode;

import util.TreeNode;
import util.Utils;

import java.util.*;

public class Leetcode199 {

	public static void main(String[] args) {
		Leetcode199 leetcode199 = new Leetcode199();
		List<Integer> integers1 = leetcode199.rightSideView(Utils.deserialize("1,2,3,null,5,null,4"));
		System.out.println(integers1);
	}

	public List<Integer> rightSideView(TreeNode root) {
		//层序遍历，将每层最后一个元素存入集合
		Deque<TreeNode> queue = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		if (root == null) {//特判
			return res;
		}
		queue.add(root);//根节点入队
		while (!queue.isEmpty()) {//外层循环，每进行一次循环相当于走了一层
			int size = queue.size();//预先定义for循环遍历的次数，因为之后队列的大小是会发生变化的
			TreeNode node = queue.getLast();//获取该层最后一个节点
			res.add(node.val);//将该节点的值加入结果集
			for (int i = 0; i < size; i++) {//队列中的前size个元素为该层元素，我们对该层元素依次遍历
				TreeNode cur = queue.poll();
				if (cur.left != null)//左节点不为空，则加入队列
					queue.add(cur.left);
				if (cur.right != null)//右节点不为空，则加入队列
					queue.add(cur.right);
			}
		}
		return res;
	}

	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> levelQueue = new LinkedList<>();
		if (root == null) {
			return result;
		}
		queue.add(root);
		levelQueue.add(1);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int level = levelQueue.poll();
			if (levelQueue.isEmpty() || levelQueue.peek() != level) {
				result.add(node.val);
			}
			if (node.left != null) {
				queue.add(node.left);
				levelQueue.add(level + 1);
			}
			if (node.right != null) {
				queue.add(node.right);
				levelQueue.add(level + 1);
			}
		}
		return result;
	}

}
