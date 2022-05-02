package leetcode;

import java.util.Arrays;

public class Leetcode62 {
	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		int[] firstRow = dp[0];
		Arrays.fill(firstRow, 1);

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int i = uniquePaths(7, 3);
		System.out.println(i);
	}
}
