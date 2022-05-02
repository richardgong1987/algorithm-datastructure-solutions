package programmerxiaohui2.chapter3.part4;

import util.Utils;

public // Floyd Warshall Algorithm in Java

class FloydWarshall {
	final static int INF = 9999;

	// Implementing floyd warshall algorithm
	static void floydWarshall(int[][] graph) {
		int n = graph.length;
		System.out.println("=========== init =============");
		Utils.printArray(graph);
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if (graph[i][k] + graph[k][j] < graph[i][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
			System.out.println("*****************");
			System.out.printf("k=%s %n", k);
			Utils.printArray(graph);
		}
	}

	public static void main(String[] args) {
		int[][] graph = {
				{0, 3, INF, 5},
				{2, 0, INF, 4},
				{INF, 1, 0, INF},
				{INF, INF, 2, 0}
		};

		floydWarshall(graph);
	}
}
