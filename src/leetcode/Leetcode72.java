package leetcode;

import util.Utils;

public class Leetcode72 {
	public static void main(String[] args) {
		int i = minDistance("horse", "ros");
	}

	static int minDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		// base case
		for (int i = 1; i <= m; i++)
			dp[i][0] = i;
		for (int j = 1; j <= n; j++)
			dp[0][j] = j;
		Utils.printArray(dp);

		// 自底向上求解
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = min(
							dp[i - 1][j] + 1,
							dp[i][j - 1] + 1,
							dp[i - 1][j - 1] + 1
					);
				}

				System.out.printf("""

								i=%s,j=%s,
								s1[(i-1)=%s]=%s,
								s2[(j-1)=%s]=%s,
								                  
								if=%s
									dp[i=%s][j=%s] = dp[(i-1)=%s][(j-1)=%s];
									dp[i=%s][j=%s]=%s                    
								else
									dp[i=%s][j=%s] = min(
									  dp[(i-1)=%s)][j=%s]+1=%s,
									  dp[i=%s][(j-1)=%s]+1=%s,
									  dp[(i-1)=%s][(j-1)=%s]+1=%s
									);
								dp[i=%s][j=%s]=%s 			
														                       								                       
																""",
						i, j,

						i - 1, s1.charAt(i - 1),
						j - 1, s2.charAt(j - 1),

						s1.charAt(i - 1) == s2.charAt(j - 1),

						//if
						i, j,
						i - 1,
						j - 1,
						dp[i - 1][j - 1],
						i, j,
						dp[i][j],

						// else
						i, j,

						i - 1,
						j,
						dp[i - 1][j] + 1,

						i,
						j - 1,
						dp[i][j - 1] + 1,

						i - 1,
						j - 1,

						dp[i - 1][j - 1] + 1,

						i, j,
						dp[i][j]
				);
				Utils.printArray(dp);
				System.out.println("------------------");
			}
			System.out.println("*********************************");
		}
		// 储存着整个 s1 和 s2 的最小编辑距离
		return dp[m][n];
	}

	static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
