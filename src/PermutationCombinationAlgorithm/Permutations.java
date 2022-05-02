package PermutationCombinationAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	// for debug
	private static int count = 0;

	// for debug
	private static void print(String str) {
		System.out.println(" ".repeat(count) + str);
	}

	public static void main(String[] args) {
		List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4});
		System.out.println(permute);
	}

	public static List<List<Integer>> permute(int[] input) {
		List<List<Integer>> outPut = new ArrayList<>();
		if (input == null || input.length == 0) {
			return outPut;
		}

		boolean[] visited = new boolean[input.length];

		List<Integer> minResult = new ArrayList<>();
		dfs(input, visited, minResult, outPut);
		return outPut;
	}

	private static void dfs(int[] nums, boolean[] visited, List<Integer> minResult, List<List<Integer>> outPut) {
		if (minResult.size() == nums.length) {
			outPut.add(new ArrayList<>(minResult));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			minResult.add(nums[i]);
			//debug start
			count++;
			print("visited=" + Arrays.toString(visited) + ",i=" + i + ",minResult=" + minResult);
			//debug end

			dfs(nums, visited, minResult, outPut);
			minResult.remove(minResult.size() - 1);
			visited[i] = false;

			//debug start
			--count;
			print("##visited=" + Arrays.toString(visited) + ",i=" + i + ",minResult=" + minResult);
			//debug end
		}
	}

}
