package PermutationCombinationAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	// for debug
	private static int count = 0;

	// for debug
	private static void print(String str) {
		System.out.println(" ".repeat(count) + str);
	}

	public static void main(String[] args) {
		List<List<Integer>> combine = combine(4, 3);
		System.out.println(combine);
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> outPut = new ArrayList<>();
		if (k <= 0 || n < k) {
			return outPut;
		}

		List<Integer> minResult = new ArrayList<>();
		dfs(n, k, 1, minResult, outPut);

		return outPut;
	}

	private static void dfs(int n, int k, int pos, List<Integer> minResult, List<List<Integer>> outPut) {
		if (minResult.size() == k) {
			outPut.add(new ArrayList<>(minResult));
			return;
		}

		for (int i = pos; i <= n; i++) {
			minResult.add(i);
			//debug start
			count++;
			print(" i=" + i + ",minResult=" + minResult);
			//debug end

			dfs(n, k, i + 1, minResult, outPut);
			minResult.remove(minResult.size() - 1);
			//debug start
			--count;
			print(" ## i=" + i + ",minResult=" + minResult);
			//debug end

		}
	}

}
