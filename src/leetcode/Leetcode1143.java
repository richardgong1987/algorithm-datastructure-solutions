package leetcode;

import util.Utils;

import java.util.Arrays;

public class Leetcode1143 {


	// 备忘录，消除重叠子问题
	static int[][] memo;

	static int longestCommonSubsequence(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		// 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
		// 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
		// base case: dp[0][..] = dp[..][0] = 0

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 现在 i 和 j 从 1 开始，所以要减一
				System.out.printf("i=%s,j=%s,(i-1)=%s,(j-1)=%s, %s,%s,%s %n", i, j, i - 1, j - 1, s1.charAt(i - 1), s2.charAt(j - 1), s1.charAt(i - 1) == s2.charAt(j - 1));
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					// s1[i-1] 和 s2[j-1] 必然在 lcs 中
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					// s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
				Utils.printArray(dp);
				System.out.println("----------------");
			}
			System.out.println("**************************");
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		int i = longestCommonSubsequence("zabc", "acezg");
		System.out.println(i);
	}

	/* 主函数 */
	static int longestCommonSubsequence2(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		// 备忘录值为 -1 代表未曾计算
		memo = new int[m][n];
		for (int[] row : memo)
			Arrays.fill(row, -1);
		// 计算 s1[0..] 和 s2[0..] 的 lcs 长度
		return dp(s1, 0, s2, 0);
	}


	// 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
	static int dp(String s1, int i, String s2, int j) {
		// base case
		if (i == s1.length() || j == s2.length()) {
			return 0;
		}

		// 如果之前计算过，则直接返回备忘录中的答案
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		// 根据 s1[i] 和 s2[j] 的情况做选择

		if (s1.charAt(i) == s2.charAt(j)) {
			// s1[i] 和 s2[j] 必然在 lcs 中
			memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
		} else {
			// s1[i] 和 s2[j] 至少有一个不在 lcs 中
			memo[i][j] = Math.max(
					dp(s1, i + 1, s2, j),
					dp(s1, i, s2, j + 1)
			);
		}
		return memo[i][j];
	}
}
