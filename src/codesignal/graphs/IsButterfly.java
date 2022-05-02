package codesignal.graphs;

public class IsButterfly {
	boolean solution(boolean[][] adj) {
		int len = adj.length;
		int[] degs = new int[len];
		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len; b++) {
				if (adj[a][b]) {
					if (a != b) {
						degs[a]++;
					} else {
						return false;
					}
				}
			}
		}

		int[] degCounts = new int[len + 1];
		for (int a = 0; a < len; a++) {
			degCounts[degs[a]]++;
		}

		return degCounts[4] == 1 && degCounts[2] == 4;
	}

}
