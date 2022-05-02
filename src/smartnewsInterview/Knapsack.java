package smartnewsInterview;

import util.Utils;

public class Knapsack {
	public static void main(String[] args) {
//		int w = 4;
//		int n = 3;
//		int[] wt = new int[]{1, 2, 3};
//		int[] val = new int[]{10, 20, 30};

		int n = 3, w = 4;
		int[] wt = new int[]{2, 1, 3};
		int[] val = new int[]{4, 2, 3};
		int i2 = maxKnapsack2(w, n, wt, val);
		System.out.println(i2);
	}

	static int maxKnapsack2(int W, int N, int[] wt, int[] val) {
		// base case 已初始化
		int[][] dp = new int[N + 1][W + 1];

		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				if (w - wt[i - 1] < 0) {
					// 这种情况下只能选择不装入背包
					dp[i][w] = dp[i - 1][w];
				} else {
					// 装入或者不装入背包，择优
					dp[i][w] = Math.max(
							dp[i - 1][w - wt[i - 1]] + val[i - 1],//装入
							dp[i - 1][w] // 不装入
					);
				}
			}
		}
		return dp[N][W];
	}


	static int maxKnapsack(int w, int n, int[] val, int[] wt) {
		// Populate base cases
		int[][] mat = new int[n + 1][w + 1];

		// Main logic
		for (int item = 1; item <= n; item++) {
			for (int capacity = 1; capacity <= w; capacity++) {
				System.out.printf("item=%s,capacity=%s %n", item, capacity);
				int maxValWithoutCurr = mat[item - 1][capacity]; // This is guaranteed to exist
				System.out.printf("mat[item(%s)-1=%s][capacity(%s)], maxValWithoutCurr=%s, wt[item - 1]=%s, %n%n", item, item - 1, capacity, maxValWithoutCurr, wt[item - 1]);
				int maxValWithCurr = 0; // We initialize this value to 0

				int weightOfCurr = wt[item - 1]; // We use item -1 to account for the extra row at the top
				if (capacity >= weightOfCurr) { // We check if the knapsack can fit the current item
					maxValWithCurr = val[item - 1]; // If so, maxValWithCurr is at least the value of the current item

					int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
					maxValWithCurr += mat[item - 1][remainingCapacity]; // Add the maximum value obtainable with the remaining capacity
				}

				mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); // Pick the larger of the two

				Utils.printArray(mat);
				System.out.println("--------------------");
			}
		}
		return mat[n][w];
	}


}
