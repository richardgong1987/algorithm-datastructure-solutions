package leetcode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode501 {


	public int[] findMode(TreeNode root) {

		HashMap<Integer, Integer> freq = new HashMap<>();
		int maxFreq = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null) {
			return new int[]{};
		}

		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			freq.put(node.val, freq.getOrDefault(node.val, 0) + 1);
			int freqCurrent = freq.get(node.val);
			if (maxFreq < freqCurrent) {
				list = new ArrayList<>();
				maxFreq = freqCurrent;
			}

			if (freqCurrent == maxFreq) {
				list.add(node.val);
			}

			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}

		int[] outPut = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			outPut[i] = list.get(i);
		}
		return outPut;
	}
}
