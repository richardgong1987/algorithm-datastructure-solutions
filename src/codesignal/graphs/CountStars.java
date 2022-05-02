package codesignal.graphs;

import java.util.*;

public class CountStars {
	int solution(boolean[][] adj) {
		int n = adj.length;
		int[] deg = new int[n];

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				if (adj[a][b]) {
					deg[a]++;
				}
			}
		}

		boolean[] flag = new boolean[n];
		Arrays.fill(flag, true);
		int starCount = 0;

		for (int i = 0; i < n; i++) {
			if (flag[i]) {
				List<Integer> vertices = spread(i, adj, flag);
				int size = vertices.size();

				if (size > 1) {
					int count1 = 0;
					int countK1 = 0;
					for (int vertex : vertices) {
						if (deg[vertex] == 1) {
							count1++;
						}
						if (deg[vertex] == size - 1) {
							countK1++;
						}
					}

					if (size == 2 && count1 == 2) {
						starCount++;
					}
					if (size > 2) {
						if (count1 == size - 1 && countK1 == 1) {
							starCount++;
						}
					}
				}
			}
		}

		return starCount;
	}

	List<Integer> spread(int vertex, boolean[][] adj, boolean[] flag) {
		List<Integer> vertices = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		flag[vertex] = false;
		while (!q.isEmpty()) {
			int v = q.poll();
			vertices.add(v);
			for (int i = 0; i < adj.length; i++) {
				if (flag[i] && adj[v][i]) {
					q.add(i);
					flag[i] = false;
				}
			}

		}
		return vertices;
	}
}
