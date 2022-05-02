package codesignal.graphs;

public class IsBook {
	boolean solution(boolean[][] adj) {
		int len = adj.length;
		int[] degs = new int[len];

		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len; b++) {
				if (adj[a][b]) {
					if (a == b) {
						return false;
					}
					degs[a]++;
				}
			}
		}

		int[] counts = new int[len];
		for (int deg: degs) {
			counts[deg]++;
		}

		return len == 2 && counts[1] == 2 ||
				len == 3 && counts[2] == 3 ||
				len > 3 && counts[2] == len - 2 && counts[len-1] == 2;
	}
}
