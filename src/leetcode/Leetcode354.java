package leetcode;

import java.util.Arrays;

public class Leetcode354 {

	// envelopes = [[w, h], [w, h]...]
	static final int FIRST = 0;
	static final int SECOND = 1;

	public static int lengthOfLIS(int[] nums) {
		int[] top = new int[nums.length];
		// 牌堆数初始化为 0
		int piles = 0;
		for (int poker : nums) {
			/***** 搜索左侧边界的二分查找 *****/
			int left = 0;
			int right = piles;
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
		}
		// 牌堆数就是 LIS 长度
		return piles;
	}

	public static void main(String[] args) {
		int i = maxEnvelopes(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {5, 5}, {6, 7}, {7, 8}}); //Russian doll is 3, [2,3] => [5,4] => [6,7]
		System.out.println(i);
	}

	public static int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		// 按宽度升序排列，如果宽度一样，则按高度降序排列
		Arrays.sort(envelopes, (a, b) -> a[FIRST] == b[FIRST] ?
				b[SECOND] - a[SECOND] : a[FIRST] - b[FIRST]);
		// 对高度数组寻找 LIS
		int[] height = new int[n];
		for (int i = 0; i < n; i++)
			height[i] = envelopes[i][SECOND];

		return lengthOfLIS(height);
	}

}
