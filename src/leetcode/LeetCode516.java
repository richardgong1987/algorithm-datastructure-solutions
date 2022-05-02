package leetcode;

import java.util.Arrays;

public class LeetCode516 {
	static int longestPalindromeSubseq(String s) {
		int n = s.length();
		// dp 数组全部初始化为 0
		int[][] dp = new int[n][n];
		// base case
		for (int i = 0; i < n; i++)
			dp[i][i] = 1;

		printArray(dp);
		// 反着遍历保证正确的状态转移
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				System.out.printf("s.charAt(i=%s)=%s,s.charAt(j=%s)=%s %s, dp[i + 1][j - 1]=%s,dp[i + 1][j]=%s,dp[i][j - 1]=%s %n", i, s.charAt(i), j, s.charAt(j), s.charAt(i) == s.charAt(j), dp[i + 1][j - 1], dp[i + 1][j], dp[i][j - 1]);
				// 状态转移方程
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
				printArray(dp);
			}
			System.out.println("*****************");
		}
		// 整个 s 的最长回文子串长度
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		int bbbab = longestPalindromeSubseq("bbbab");

	}

	static void printArray(int[][] dbs) {
		for (int[] db : dbs) {
			System.out.println(Arrays.toString(db));
		}
	}

	public int longestPalindromeSubseq2(String s) {
		String text1 = s;
		String text2 = new StringBuilder(s).reverse().toString();
		int n = s.length();
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[n][n];
	}
}
