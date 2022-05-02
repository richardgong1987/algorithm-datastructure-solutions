package leetcode;

import java.util.HashMap;

public class Leetcode560 {


	static int subarraySum2(int[] nums, int k) {
		int n = nums.length;
		// 构造前缀和
		int[] preSum = new int[n + 1];
		preSum[0] = 0;
		for (int i = 0; i < n; i++)
			preSum[i + 1] = preSum[i] + nums[i];

		int res = 0;
//		// 穷举所有子数组
//		for (int i = 1; i <= n; i++)
//			for (int j = 0; j < i; j++)
//				// 子数组 nums[j..i-1] 的元素和
//				if (preSum[i] - preSum[j] == k)
//					res++;

		// 穷举所有子数组
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < i; j++)
				// 在计算，有几个 j 能够使得 preSum[i] 和 preSum[j] 的差为 k。毎找到一个这样的 j，就把结果加一。
				//我们可以把 if 语句里的条件判断移项，这样写：
				if (preSum[j] == preSum[i] - k)
					res++;
		return res;
	}

	/**
	 * 问题:
	 * 和为K的子数组
	 * <p>
	 * 思路：
	 * 我直接记录下有几个 preSum[j] 和 preSum[i] - k 相等，直接更新结果
	 * ，就避免了内层的 for 循环。我们可以用哈希表，在记录前缀和的同时记录该前缀和出现的次数。
	 */
	static int subarraySum(int[] nums, int k) {
		// map：前缀和 -> 该前缀和出现的次数
		HashMap<Integer, Integer>
				preSum = new HashMap<>();
		// base case
		preSum.put(0, 1);

		int res = 0;
		int sum0toI = 0;
		for (int num : nums) {
			sum0toI += num;
			// 这是我们想找的前缀和 nums[0..j]
			int sum0toJ = sum0toI - k;

			// 如果前面有这个前缀和，则直接更新答案
			if (preSum.containsKey(sum0toJ)) {
				res += preSum.get(sum0toJ);
			}

			// 把前缀和 nums[0..i] 加入并记录出现次数
			preSum.put(sum0toI,
					preSum.getOrDefault(sum0toI, 0) + 1);

		}
		return res;
	}


}
