package codesignal.graphs;

public class EfficientRoadNetwork {
	public static void main(String[] args) {
		EfficientRoadNetwork ef = new EfficientRoadNetwork();
		System.out.println(ef.solution(6, new int[][]
				{
						{3, 0},
						{0, 4},
						{5, 0},
						{2, 1},
						{1, 4},
						{2, 3},
						{5, 2}
				}));
	}

	boolean solution(int n, int[][] roads) {
		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = 3;
			}
			graph[i][i] = 0;
		}

		for (int[] road : roads) {
			int x = road[0];
			int y = road[1];
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		var id = 1;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] > 2) {
					return false;
				}
			}
		}
		return true;
	}
}
