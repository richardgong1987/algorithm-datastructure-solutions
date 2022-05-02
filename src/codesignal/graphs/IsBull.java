package codesignal.graphs;

public class IsBull {
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

		int[] counts = new int[n];
		for (int i = 0; i < n; i++) {
			counts[degs[i]]++;
		}

		if (counts[4] == 1 && counts[1] == 2 && counts[2] == 2) {
			return true;
		}

		if (counts[3] == 2 && counts[2] == 1 && counts[1] == 2) {
			int[] c2 = new int[2];
			int idx2 = 0;
			for (int i = 0; i < n; i++) {
				if (degs[i] == 3) {
					c2[idx2++] = i;
				}
			}

			if (adj[c2[0]][c2[1]]) {
				for (int i = 0; i < n; i++) {
					if (degs[i] == 2) {
						if (adj[i][c2[0]] && adj[i][c2[1]]) {
							return true;
						}
					}
				}
			}
		}

		if (counts[3] == 1 && counts[2] == 3 && counts[1] == 1) {
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					for (int c = 0; c < n; c++) {
						if (degs[a] == 3 && adj[a][b] && adj[b][c] && adj[c][a]) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}
}
