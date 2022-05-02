package codesignal.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RedAlert {
	int solution(int nodes, int[] corridor, int k) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= nodes; i++) graph.add(new ArrayList<>());
		for (int i = 1; i < corridor.length; i += 2) {
			graph.get(corridor[i]).add(corridor[i - 1]);
			graph.get(corridor[i - 1]).add(corridor[i]);
		}

		boolean[][] visited = new boolean[nodes + 1][k];
		for (int i = 1; i <= nodes; i++) visited[i][i % k] = true;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int timeStep = 1, frontierSize = 1;
		visited[1][0] = true;
		queue.add(1);
		while (!queue.isEmpty()) {
			int parentNode = queue.removeFirst();
			frontierSize--;
			for (Integer node : graph.get(parentNode)) {
				if (!visited[node][timeStep % k]) {
					if (node == nodes) return timeStep;
					visited[node][timeStep % k] = true;
					queue.addLast(node);
				}
			}
			if (frontierSize == 0) {
				frontierSize = queue.size();
				timeStep++;
			}
		}
		return -1;
	}
}
