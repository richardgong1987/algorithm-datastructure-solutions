package codesignal.graphs;

public class FrustratedAborigines {
	int solution(int[][] bridges, int[] crowd) {
		int result = 0;
		for (int i = 0; i < bridges.length; i++) {
			int count = reachableCount(i, bridges, new boolean[bridges.length]);
			result += (bridges.length - count) * crowd[i];
		}
		return result;
	}

	private int reachableCount(int node, int[][] graph, boolean[] visited) {
		visited[node] = true;
		int reachableNodes = 0;
		for (int i : graph[node])
			if (!visited[i])
				reachableNodes += reachableCount(i, graph, visited);
		return reachableNodes + 1;
	}
}
