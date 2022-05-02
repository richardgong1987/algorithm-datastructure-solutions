package leetcode;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode437 {

	int count = 0;

	public int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		helper(root, 0, sum, map);
		return count;
	}

	public void helper(TreeNode root, int curSum, int target, Map<Integer, Integer> map) {
		// corner case
		if (root == null) {
			return;
		}
		// normal case
		curSum += root.val;
		if (map.containsKey(curSum - target)) {
			count += map.get(curSum - target);
		}
		if (!map.containsKey(curSum)) {
			map.put(curSum, 1);
		} else {
			map.put(curSum, map.get(curSum) + 1);
		}
		helper(root.left, curSum, target, map);
		helper(root.right, curSum, target, map);
		map.put(curSum, map.get(curSum) - 1);
	}

	public int pathSum2(TreeNode root, int sum) {
		if (root == null) return 0;
		return numberOfPaths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	int numberOfPaths(TreeNode root, int left) {
		if (root == null) return 0;
		left -= root.val;
		return (left == 0 ? 1 : 0) + numberOfPaths(root.left, left) + numberOfPaths(root.right, left);
	}
}
