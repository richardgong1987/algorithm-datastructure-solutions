package leetcode;

import java.util.Arrays;

public class Leetcode300 {

	public static int lengthOfLIS2(int[] nums) {
		int[] top = new int[nums.length];
		// 牌堆数初始化为 0
		int piles = 0;
		for (int i = 0; i < nums.length; i++) {
			// 要处理的扑克牌
			int poker = nums[i];
			System.out.println("poker=" + poker);
			/***** 搜索左侧边界的二分查找 *****/
			int left = 0;
			int right = piles;
			System.out.println("right=" + right);
			while (left < right) {
				int mid = (left + right) / 2;
				if (top[mid] > poker) {
					right = mid;
				} else if (top[mid] < poker) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			/*********************************/
			// 没找到合适的牌堆，新建一堆
			if (left == piles) piles++;
			// 把这张牌放到牌堆顶
			top[left] = poker;
			System.out.println("top[" + left + "]=" + poker);
			System.out.println("piles=" + piles);
			System.out.println("******" + i + "**********");
		}
		// 牌堆数就是 LIS 长度
		return piles;
	}

	public static void main(String[] args) {
		int i = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
	}

	static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		// base case：dp 数组全都初始化为 1
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int res = 0;
		for (int j : dp) {
			res = Math.max(res, j);
		}
		return res;
	}
}
