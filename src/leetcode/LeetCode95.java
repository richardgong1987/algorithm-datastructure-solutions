package leetcode;

public class LeetCode95 {
	// 备忘录
	static int[][] memo;

	// for debug
	private static int count = 0;

	// for debug
	private static void print(int cnt, String str) {
		System.out.println(" ".repeat(cnt) + str);
	}

	public static void main(String[] args) {
		int i = numTrees(3);
		System.out.println(i);
	}

	static int numTrees(int n) {
		// 备忘录的值初始化为 0
		memo = new int[n + 1][n + 1];
		return count(1, n);
	}

	static int count(int lo, int hi) {
		if (lo > hi) return 1;
		// 查备忘录
		if (memo[lo][hi] != 0) {
			return memo[lo][hi];
		}
		int res = 0;
		for (int mid = lo; mid <= hi; mid++) {
			print(count++, " lo=" + lo + ",mid=" + mid + ",hi=" + hi);
			int left = count(lo, mid - 1);
			int right = count(mid + 1, hi);
			print(--count, " ## lo=" + lo + ",mid=" + mid + ",hi=" + hi);
			res += left * right;
		}
		// 将结果存入备忘录
		memo[lo][hi] = res;
		return res;
	}


}
