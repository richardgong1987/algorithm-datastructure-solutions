package codility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IsCycle {
	public static void main(String[] args) {
		Boolean r = solution(3, new int[]{0,1,1,2,2,0});
		System.out.println(r);
	}

	public static Boolean solution(int size, int[] edges) {
		if (edges.length == 0) {
			return false;
		}
		Graph graph = new Graph(size);
		for (int i = 0; i < size - 1; i++) {
			graph.addEdge(edges[i], edges[i + 1]);
		}
		return graph.isCycle();
	}

	public static class Graph {
		private int V;
		private List<List<Integer>> adj;
		public Graph(int V) {
			this.V = V;
			this.adj = new ArrayList<>(V);
			for (int i = 0; i < V; i++) {
				adj.add(new LinkedList<>());
			}
		}
		private boolean checkIsCycle(int i, boolean[] visited, boolean[] recStack) {
			if (recStack[i]) {
				return true;
			}
			if (visited[i]) {
				return false;
			}
			visited[i] = true;
			recStack[i] = true;
			List<Integer> children = adj.get(i);
			for (Integer c : children) {
				if (this.checkIsCycle(c, visited, recStack)) {
					return true;
				}
			}
			recStack[i] = false;
			return false;
		}

		public void addEdge(int from, int to) {
			adj.get(from).add(to);
		}
		public boolean isCycle() {
			boolean[] visited = new boolean[V];
			boolean[] recStack = new boolean[V];

			for (int i = 0; i < V; i++) {
				if (checkIsCycle(i, visited, recStack)) {
					return true;
				}
			}
			return false;
		}
	}
}
