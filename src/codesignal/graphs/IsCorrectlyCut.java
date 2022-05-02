package codesignal.graphs;

public class IsCorrectlyCut {
	boolean solution(boolean[][] adj) {
		boolean f1 = filter1(adj);
		if (!f1) {
			return false;
		}
		return filter2(adj);
	}

	private boolean filter2(boolean[][] adj) {
		int len = adj.length;
		int[] deg = new int[len];
		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len; b++) {
				if (adj[a][b]) {
					if (a == b) {
						return false;
					}
					deg[a]++;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			if (deg[i] != len / 2 - 1) {
				return false;
			}
		}
		return true;
	}

	boolean filter1(boolean[][] adj) {
		int len = adj.length;
		if (len % 2 == 1) {
			return false;
		}
		int[] flag = new int[len];

		for (int i = 0; i < len; i++) {
			if (flag[i] == 0) {
				spread(i, 1, flag, adj);
			}
		}

		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len; b++) {
				if (adj[a][b] && flag[a] == flag[b]) {
					return false;
				}
			}
		}
		return true;
	}

	private void spread(int i, int color, int[] flag, boolean[][] adj) {
		flag[i] = color;
		for (int a = 0; a < flag.length; a++) {
			if (flag[a] == 0 && adj[i][a]) {
				spread(a, 3 - color, flag, adj);
			}
		}
	}
}
