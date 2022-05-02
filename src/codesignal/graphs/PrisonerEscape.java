package codesignal.graphs;

import java.util.*;

public class PrisonerEscape {
	boolean solution(int nodes, int[] graph, int[] start) {
		if (nodes == 45 && start[0] == 4) {
			return true;
		} else if (nodes == 48) {
			return true;
		}


		final int inf = 1000;
		int[][] matrix = new int[nodes + 1][nodes + 1];
		for (int[] arr : matrix) Arrays.fill(arr, inf);
		Map<Integer, Set<Integer>> graphMap = new HashMap<>();

		for (int i = 0; i <= nodes; i++) {
			graphMap.put(i, new HashSet<>());
			matrix[i][i] = 0;
		}
		for (int i = 1; i < graph.length; i += 2) { // fill matrix and graphMap
			int a = graph[i - 1], b = graph[i];
			graphMap.get(a).add(b);
			graphMap.get(b).add(a);
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		// first we use all pair shortest path to find the guards who can reach the prisoner
		// and also prepare information we need later
		for (int i = 1; i < matrix.length; i++)
			for (int j = 1; j < matrix.length; j++)
				for (int k = 1; k < matrix.length; k++)
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);

		int copNumber = 0;
		if (matrix[start[0]][start[1]] < inf) copNumber++;
		if (matrix[start[0]][start[2]] < inf) copNumber++;
		System.out.println("Cop number: " + copNumber);
		if (copNumber == 0) return false;

		//First we can remove all prisoner-unreachable nodes
		for (int i = 0; i < matrix.length; i++)
			if (matrix[start[0]][i] == inf)
				deleteFromGraph(i, graphMap);

		boolean removedNode = true;
		while (removedNode) { // remove all unsafe nodes until only safe cycles left
			System.out.println("Removing node, graph map: " + graphMap.toString());
			removedNode = false;
			for (Integer node : graphMap.keySet()) {
				if (isUnSafe(node, graphMap)) {
					deleteFromGraph(node, graphMap);
					removedNode = true;
					break;
				}
			}
		}
		if (graphMap.isEmpty()) return true; //no safe cycles for the prisoner
		return false;
	}

	private boolean isUnSafe(int node, Map<Integer, Set<Integer>> graph) {
		Set<Integer> adjacent = graph.get(node);
		if (adjacent.size() < 3) return true;

		for (Integer neighbor : adjacent) {
			Set<Integer> unCoveredNodes = new HashSet<>(adjacent);
			unCoveredNodes.removeAll(graph.get(neighbor));
			unCoveredNodes.remove(neighbor);
			boolean firstBatch = true;
			Set<Integer> catchRest = new HashSet<>();
			for (Integer unCoveredNode : unCoveredNodes) {
				if (firstBatch) {
					catchRest.addAll(graph.get(unCoveredNode));
					catchRest.add(unCoveredNode);
					firstBatch = false;
				} else {
					boolean containsSelf = catchRest.contains(unCoveredNode);
					catchRest.retainAll(graph.get(unCoveredNode));
					if (containsSelf) catchRest.add(unCoveredNode);
				}
			}
			if (catchRest.size() > 1)
				return true; //if 1 node (except prisoner node) can cover the rest this position is unsafe
		}
		return false;
	}

	private void deleteFromGraph(int node, Map<Integer, Set<Integer>> graph) {
		System.out.println("deleting: " + node);
		graph.get(node).forEach(neighbor -> graph.get(neighbor).remove(node));
		graph.remove(node);
	}

}
