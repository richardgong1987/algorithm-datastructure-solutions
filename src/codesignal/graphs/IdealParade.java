package codesignal.graphs;

import java.util.*;

public class IdealParade {

	int[] solution(int n, int[][] bridges, int[] times) {
		List<SortedSet<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			graph.add(new TreeSet<>(Comparator.comparingInt(arr -> arr[2])));
		for (int[] bridge : bridges)
			graph.get(bridge[0]).add(bridge);

		int[] output = new int[bridges.length + 1];
		int outputIndex = 1, currentNode = 1;
		output[0] = 1;
		while (outputIndex < output.length) {
			SortedSet<int[]> edges = graph.get(currentNode);
			if (edges.size() == 1) {
				currentNode = edges.first()[1];
				edges.clear();
			} else {
				int[] selectedNode = null;
				for (int[] edge : edges) {
					if (isConnected(edge[1], edge[0], graph)) {
						selectedNode = edge;
						break;
					}
				}
				if (selectedNode == null) break;
				else {
					edges.remove(selectedNode);
					currentNode = selectedNode[1];
				}
			}
			output[outputIndex] = currentNode;
			outputIndex++;
		}
		System.out.println(Arrays.toString(output));
		if (outputIndex < output.length || currentNode != 1)
			return new int[0];

		int[] result = new int[times.length];
		for (int i = 0; i < times.length; i++)
			result[i] = output[times[i]];
		return result;
	}

	private boolean isConnected(int node, int target, List<SortedSet<int[]>> graph) {
		if (node == target)
			return true;
		boolean[] visited = new boolean[graph.size()];
		visited[node] = true;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			for (int[] bridge : graph.get(queue.remove())) {
				if (bridge[1] == target)
					return true;
				if (!visited[bridge[1]]) {
					visited[bridge[1]] = true;
					queue.add(bridge[1]);
				}
			}
		}
		return false;
	}

}
