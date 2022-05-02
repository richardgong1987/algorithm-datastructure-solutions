package codesignal.graphs;

import java.util.*;

public class NumberOfPlans {
	int solution(int n, int[][] streets) {
		Arrays.sort(streets, Comparator.comparingInt(arr -> arr[2]));

		final int MOD = 1000000007;
		List<List<Integer>> spanningTree = new ArrayList<>();
		int[] parent = new int[n];
		long scalarMultiple = 1, matrix[][] = new long[n][n];

		for (int i = 0; i < n; i++) spanningTree.add(new ArrayList<>());
		for (int i = 0; i < n; i++) parent[i] = i;
		for (int[] street : streets) {
			int rootA = getRoot(street[0], parent), rootB = getRoot(street[1], parent);

			if (rootA == rootB) continue;

			spanningTree.get(street[0]).add(street[1]);
			spanningTree.get(street[1]).add(street[0]);
			parent[rootA] = rootB;
		}

		Map<String, Map<Integer, Integer>> exponentMap = new HashMap<>();

		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) exponentMap.put(i + "," + j, new HashMap<>());
		for (int[] street : streets) {
			int from = street[0], to = street[1], weight = street[2];
			Map<Integer, Integer> tempMap = exponentMap.get(from + "," + from);

			tempMap.put(weight, tempMap.getOrDefault(weight, 0) + 1);
			tempMap = exponentMap.get(to + "," + to);
			tempMap.put(weight, tempMap.getOrDefault(weight, 0) + 1);
			tempMap = exponentMap.get(from + "," + to);
			tempMap.put(weight, tempMap.getOrDefault(weight, 0) - 1);
			tempMap = exponentMap.get(to + "," + from);
			tempMap.put(weight, tempMap.getOrDefault(weight, 0) - 1);
		}

		traverseMSTAndAdd(n - 1, -1, spanningTree, exponentMap);

		int[] minExp = new int[n];

		Arrays.fill(minExp, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			final int index = i;

			exponentMap.get(i + "," + i).forEach((key, value) -> {
				if (value != 0) minExp[index] = Math.min(minExp[index], key);
			});
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = exponentMap.get(i + "," + j).getOrDefault(minExp[j], 0);

				if (matrix[i][j] < 0) matrix[i][j] = MOD + matrix[i][j];
			}
		}

		for (int i = 0; i < n - 1; i++) {
			long modInverse = modInverse(matrix[i][i], MOD);

			scalarMultiple = (scalarMultiple * modInverse) % MOD;

			for (int j = i; j < n; j++) matrix[i][j] = (matrix[i][j] * modInverse) % MOD;
			for (int k = i + 1; k < n - 1; k++) {
				if (matrix[k][i] == 0) continue;

				long scalar = MOD - matrix[k][i];

				for (int j = i; j < n; j++) matrix[k][j] = (matrix[k][j] + matrix[i][j] * scalar) % MOD;
			}
		}

		return (int) modInverse(scalarMultiple, MOD);
	}

	int getRoot(int node, int[] tree) {
		while (node != tree[node]) {
			tree[node] = tree[tree[node]];
			node = tree[node];
		}

		return node;
	}

	void traverseMSTAndAdd(int node, int parent, List<List<Integer>> tree, Map<String, Map<Integer, Integer>> expMap) {
		for (Integer child : tree.get(node))
			if (child != parent) traverseMSTAndAdd(child, node, tree, expMap);

		if (parent != -1) {
			for (int i = 0; i < tree.size(); i++) {
				Map<Integer, Integer> fromMap = expMap.get(i + "," + node);
				Map<Integer, Integer> targetMap = expMap.get(i + "," + parent);

				fromMap.forEach((key, value) -> targetMap.put(key, targetMap.getOrDefault(key, 0) + value));
			}
		}
	}

	long modInverse(long a, long m) {
		long exponent = m - 2, result = 1;

		while (exponent > 0) {
			if (exponent % 2 == 1) result = (result * a) % m;

			exponent >>= 1;
			a = (a * a) % m;
		}

		return result;
	}
}
