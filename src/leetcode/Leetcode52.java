package leetcode;

public class Leetcode52 {
	static int maxSubArray(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		// base case
		int dpPre = nums[0];
		int res = dpPre;

		for (int i = 1; i < n; i++) {
			// dp[i] = max(nums[i], nums[i] + dp[i-1])
			dpPre = Math.max(nums[i], nums[i] + dpPre);
			// 顺便计算最大的结果
			res = Math.max(res, dpPre);
		}

		return res;
	}

	public static void main(String[] args) {
		int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
		System.out.println(i);
	}
}
