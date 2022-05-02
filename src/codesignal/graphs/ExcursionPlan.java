package codesignal.graphs;

import java.util.ArrayList;
import java.util.List;

public class ExcursionPlan {
	int[] solution(int n, int m, int l, int r) {
		if (m == 1) return new int[1];
		if (n == 1) {
			int[] output = new int[r - l + 1];
			for (int i = l; i <= r; i++)
				output[i - l] = i;
			return output;
		}
		List<List<Integer>> graph = new ArrayList<>();
		int nodes = (int) Math.pow(m, n);
		int mod = nodes / m;
		for (int i = 0; i < nodes; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < graph.size(); i++) {
			int conIndex = i % mod;
			for (int j = 0; j < m; j++)
				graph.get(i).add(m * conIndex + j);
		}
		int[] result = new int[nodes];
		boolean[] visited = new boolean[nodes];
		visited[0] = true;
		lexFirstHamiltonian(1, 0, graph, visited, result);
		int[] output = new int[r - l + 1];
		System.arraycopy(result, l, output, 0, r + 1 - l);
		return output;
	}

	private boolean lexFirstHamiltonian(int index, int node, List<List<Integer>> graph, boolean[] visited, int[] output) {
		if (index == output.length) return true;
		for (Integer child : graph.get(node)) {
			if (visited[child]) continue;
			visited[child] = true;
			output[index] = child;
			if (lexFirstHamiltonian(index + 1, child, graph, visited, output))
				return true;
			visited[child] = false;
		}
		return false;
	}

}
