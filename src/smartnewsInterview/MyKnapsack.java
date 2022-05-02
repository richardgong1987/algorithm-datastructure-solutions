package smartnewsInterview;

public class MyKnapsack {
	public static void main(String[] args) {
		int[][] wv = new int[][]{
				{5, 60},
				{3, 50},
				{4, 70},
				{2, 30},
		};
		int maxBagCapacity = 5;
		int knapsack = knapsack(maxBagCapacity, wv);
		System.out.println(knapsack);
	}

	/**
	 * reference:
	 * video: https://www.youtube.com/watch?v=xCbYmUPvc2Q
	 * https://backtobackswe.com/platform/content/the-knapsack-problem/video?utm_source=youtube&utm_medium=video
	 * <p>
	 * formula:
	 * dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-Wi]+Vi) || dp[i-1][w]
	 */
	static public int knapsack(int maxBagCapacity, int[][] wv) {
		int[][] dp = new int[wv.length + 1][maxBagCapacity + 1];

		int WEIGHT = 0;
		int VALUE = 1;

		for (int i = 1; i <= wv.length; i++) {
			for (int w = 1; w <= maxBagCapacity; w++) {
				if (w < wv[i - 1][WEIGHT]) {
					dp[i][w] = dp[i - 1][w];
				} else {
					dp[i][w] = Math.max(
							dp[i - 1][w], // not take
							dp[i - 1][w - (wv[i - 1][WEIGHT])] + wv[i - 1][VALUE]
					); // taken
				}
			}
		}

		return dp[wv.length][maxBagCapacity];
	}

	/**
	 * reference:
	 * video: https://www.youtube.com/watch?v=xCbYmUPvc2Q
	 * https://backtobackswe.com/platform/content/the-knapsack-problem/video?utm_source=youtube&utm_medium=video
	 * <p>
	 * https://backtobackswe.com/platform/content/the-knapsack-problem/solutions
	 * <p>
	 * formula:
	 * dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-Wi]+Vi) || dp[i-1][w]
	 */
	public int knapsack(int[] values, int[] weights, int maxWeightConstraint) {

		// Create a 2D Array of Size value.size()+1 X maxWeightConstraint+1
		int[][] cache = new int[values.length + 1][maxWeightConstraint + 1];

		// Fill up the cache in Bottom Up Manner
		for (int totalItems = 0; totalItems <= values.length; totalItems++) {
			for (int maxWeight = 0; maxWeight <= maxWeightConstraint; maxWeight++) {

				int currentItem = totalItems - 1;

				// Case when number of Items are 0 OR maxWeight is 0
				if (totalItems == 0 || maxWeight == 0) {
					cache[totalItems][maxWeight] = 0;
				}

				// If weight of current Item is greater than maxWeight
				// We cannot add that item
				else if (weights[currentItem] > maxWeight) {
					cache[totalItems][maxWeight] = cache[totalItems - 1][maxWeight];
				}
				// Else check the condition of with Item or Without Item
				// And Store the maximum of both
				else {

					// 1.) Without Item -> Going up 1 row
					// 2.) With Item -> Go up 1 row & left 'weights[currentItem]' columns
					int withItem = values[currentItem] + cache[totalItems - 1][maxWeight - weights[currentItem]];
					int withoutItem = cache[totalItems - 1][maxWeight];

					cache[totalItems][maxWeight] = Math.max(withItem, withoutItem);
				}
			}
		}

		return cache[values.length][maxWeightConstraint];
	}
}
