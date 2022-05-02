package codesignal.graphs;

public class IsWheel {
	boolean solution(boolean[][] adj) {
		int len = adj.length;
		int[] degs = new int[len];
		for (int a = 0; a < len; a++) {
			if (adj[a][a]) {
				return false;
			}
			for (int b = 0; b < len; b++) {
				if (adj[a][b]) {
					degs[a]++;
				}
			}
		}

		int[] count = new int[len];
		for (int d : degs) {
			count[d]++;
		}
		return len == 4 && count[3] == 4 ||
				len > 4 && count[3] == len-1 && count[len-1] == 1;
	}
}
