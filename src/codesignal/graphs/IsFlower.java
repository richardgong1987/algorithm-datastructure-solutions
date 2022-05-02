package codesignal.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsFlower {
	boolean solution(boolean[][] adj) {
		int n = adj.length;
		int[] degs = new int[n];

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				if (adj[a][b]) {
					if (a == b) {
						return false;
					}
					degs[a]++;
				}
			}
		}

		int center = -1;
		for (int i = 0; i < n; i++) {
			if (degs[i] == n - 1) {
				center = i;
			}
		}

		if (center == -1) {
			return false;
		}

		for (int i = 0; i < n; i++) {
			adj[i][center] = false;
			adj[center][i] = false;
		}

		boolean[] flags = new boolean[n];
		Set<Integer> counts = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (i != center && !flags[i]) {
				List<Integer> vertices = new ArrayList<>();
				spread(adj, flags, i, vertices);
				if (!connected(vertices, adj)) {
					return false;
				}
				counts.add(vertices.size());
			}
		}

		return counts.size() == 1;
	}

	void spread(boolean[][] adj, boolean[] flags, int vertex, List<Integer> vertices) {
		vertices.add(vertex);
		flags[vertex] = true;
		for (int i = 0; i < flags.length; i++) {
			if (!flags[i] && adj[vertex][i]) {
				spread(adj, flags, i, vertices);
			}
		}
	}

	boolean connected(List<Integer> vertices, boolean[][] adj) {
		for (int a : vertices) {
			for (int b : vertices) {
				if (a != b && !adj[a][b]) {
					return false;
				}
			}
		}
		return true;
	}
}
